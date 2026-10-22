package okhttp3;

import androidx.collection.SieveCacheKt;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class CacheControl {
    public static final CacheControl FORCE_CACHE = null;
    public static final CacheControl FORCE_NETWORK = null;

    @Nullable
    String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    public static final class Builder {
        boolean immutable;
        int maxAgeSeconds;
        int maxStaleSeconds;
        int minFreshSeconds;
        boolean noCache;
        boolean noStore;
        boolean noTransform;
        boolean onlyIfCached;

        public Builder immutable() {
            this.immutable = true;
            return this;
        }

        public Builder noCache() {
            this.noCache = true;
            return this;
        }

        public Builder noStore() {
            this.noStore = true;
            return this;
        }

        public Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }

        public CacheControl build() {
            return new CacheControl(this);
        }

        public Builder() {
            this.maxAgeSeconds = -1;
            this.maxStaleSeconds = -1;
            this.minFreshSeconds = -1;
        }

        public Builder maxAge(int r100, TimeUnit r101) {
            if (r100 < 0) goto L10;
            long r102 = r101.toSeconds(r100);
            if (r102 <= SieveCacheKt.NodeLinkMask) goto L6;
            int r103 = Integer.MAX_VALUE;
        L7:
            this.maxAgeSeconds = r103;
            return this;
        L6:
            r103 = (int) r102;
            goto L7
        L10:
            throw new IllegalArgumentException("maxAge < 0: " + r100);
        }

        public Builder maxStale(int r100, TimeUnit r101) {
            if (r100 < 0) goto L10;
            long r102 = r101.toSeconds(r100);
            if (r102 <= SieveCacheKt.NodeLinkMask) goto L6;
            int r103 = Integer.MAX_VALUE;
        L7:
            this.maxStaleSeconds = r103;
            return this;
        L6:
            r103 = (int) r102;
            goto L7
        L10:
            throw new IllegalArgumentException("maxStale < 0: " + r100);
        }

        public Builder minFresh(int r100, TimeUnit r101) {
            if (r100 < 0) goto L10;
            long r102 = r101.toSeconds(r100);
            if (r102 <= SieveCacheKt.NodeLinkMask) goto L6;
            int r103 = Integer.MAX_VALUE;
        L7:
            this.minFreshSeconds = r103;
            return this;
        L6:
            r103 = (int) r102;
            goto L7
        L10:
            throw new IllegalArgumentException("minFresh < 0: " + r100);
        }
    }

    static {
        FORCE_NETWORK = new Builder().noCache().build();
        FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    }

    private String headerValue() {
        StringBuilder r100 = new StringBuilder();
        if (this.noCache == false) goto L6;
        r100.append("no-cache, ");
    L6:
        if (this.noStore == false) goto L9;
        r100.append("no-store, ");
    L9:
        if (this.maxAgeSeconds == (-1)) goto L12;
        r100.append("max-age=");
        r100.append(this.maxAgeSeconds);
        r100.append(", ");
    L12:
        if (this.sMaxAgeSeconds == (-1)) goto L15;
        r100.append("s-maxage=");
        r100.append(this.sMaxAgeSeconds);
        r100.append(", ");
    L15:
        if (this.isPrivate == false) goto L18;
        r100.append("private, ");
    L18:
        if (this.isPublic == false) goto L21;
        r100.append("public, ");
    L21:
        if (this.mustRevalidate == false) goto L24;
        r100.append("must-revalidate, ");
    L24:
        if (this.maxStaleSeconds == (-1)) goto L27;
        r100.append("max-stale=");
        r100.append(this.maxStaleSeconds);
        r100.append(", ");
    L27:
        if (this.minFreshSeconds == (-1)) goto L30;
        r100.append("min-fresh=");
        r100.append(this.minFreshSeconds);
        r100.append(", ");
    L30:
        if (this.onlyIfCached == false) goto L33;
        r100.append("only-if-cached, ");
    L33:
        if (this.noTransform == false) goto L36;
        r100.append("no-transform, ");
    L36:
        if (this.immutable == false) goto L39;
        r100.append("immutable, ");
    L39:
        if (r100.length() != 0) goto L42;
        return "";
    L42:
        r100.delete(r100.length() - 2, r100.length());
        return r100.toString();
    }

    public String toString() {
        String r100 = this.headerValue;
        if (r100 != null) goto L7;
        String r101 = headerValue();
        this.headerValue = r101;
        return r101;
    L7:
        return r100;
    }

    public boolean immutable() {
        return this.immutable;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public boolean noCache() {
        return this.noCache;
    }

    public boolean noStore() {
        return this.noStore;
    }

    public boolean noTransform() {
        return this.noTransform;
    }

    public boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public CacheControl(Builder r100) {
        this.noCache = r100.noCache;
        this.noStore = r100.noStore;
        this.maxAgeSeconds = r100.maxAgeSeconds;
        this.sMaxAgeSeconds = -1;
        this.isPrivate = false;
        this.isPublic = false;
        this.mustRevalidate = false;
        this.maxStaleSeconds = r100.maxStaleSeconds;
        this.minFreshSeconds = r100.minFreshSeconds;
        this.onlyIfCached = r100.onlyIfCached;
        this.noTransform = r100.noTransform;
        this.immutable = r100.immutable;
    }

    public static CacheControl parse(Headers r210) {
        int r100 = r210.size();
        int r101 = 0;
        boolean r102 = true;
        String r103 = null;
        boolean r104 = false;
        boolean r110 = false;
        int r111 = -1;
        int r112 = -1;
        boolean r113 = false;
        boolean r114 = false;
        boolean r115 = false;
        int r116 = -1;
        int r117 = -1;
        boolean r118 = false;
        boolean r119 = false;
        boolean r211 = false;
    L3:
        if (r101 >= r100) goto L75;
        String r105 = r210.name(r101);
        String r106 = r210.value(r101);
        if (r105.equalsIgnoreCase("Cache-Control") == false) goto L10;
        if (r103 != null) goto L11;
        r103 = r106;
    L12:
        int r107 = 0;
    L14:
        if (r107 >= r106.length()) goto L74;
        int r108 = evc.e.g(r106, r107, "=,;");
        String r109 = r106.substring(r107, r108).trim();
        if (r108 != r106.length()) goto L18;
    L36:
        int r120 = r108 + 1;
        String r121 = null;
    L38:
        if (HTTP.NO_CACHE.equalsIgnoreCase(r109) == false) goto L41;
        r104 = true;
    L73:
        r107 = r120;
        goto L14
    L41:
        if ("no-store".equalsIgnoreCase(r109) == false) goto L44;
        r110 = true;
        goto L73
    L44:
        if (HTTP.MAX_AGE.equalsIgnoreCase(r109) == false) goto L47;
        r111 = evc.e.c(r121, -1);
        goto L73
    L47:
        if ("s-maxage".equalsIgnoreCase(r109) == false) goto L50;
        r112 = evc.e.c(r121, -1);
        goto L73
    L50:
        if (BridgePrivilege.PRIVATE.equalsIgnoreCase(r109) == false) goto L53;
        r113 = true;
        goto L73
    L53:
        if ("public".equalsIgnoreCase(r109) == false) goto L56;
        r114 = true;
        goto L73
    L56:
        if ("must-revalidate".equalsIgnoreCase(r109) == false) goto L59;
        r115 = true;
        goto L73
    L59:
        if ("max-stale".equalsIgnoreCase(r109) == false) goto L62;
        r116 = evc.e.c(r121, Integer.MAX_VALUE);
        goto L73
    L62:
        if ("min-fresh".equalsIgnoreCase(r109) == false) goto L65;
        r117 = evc.e.c(r121, -1);
        goto L73
    L65:
        if ("only-if-cached".equalsIgnoreCase(r109) == false) goto L68;
        r118 = true;
        goto L73
    L68:
        if ("no-transform".equalsIgnoreCase(r109) == false) goto L71;
        r119 = true;
        goto L73
    L71:
        if ("immutable".equalsIgnoreCase(r109) == false) goto L73;
        r211 = true;
        goto L73
    L18:
        if (r106.charAt(r108) == ',') goto L36;
        if (r106.charAt(r108) == ';') goto L36;
    L29:
        r108 = r108 + 1;
        if (r108 >= r106.length()) goto L31;
        char r122 = r106.charAt(r108);
        if (r122 == ' ') goto L29;
        if (r122 == '\t') goto L29;
    L31:
        if (r108 < r106.length()) goto L33;
    L35:
        r120 = evc.e.g(r106, r108, ",;");
        r121 = r106.substring(r108, r120).trim();
        goto L38
    L33:
        if (r106.charAt(r108) != '\"') goto L35;
        int r123 = r108 + 1;
        int r124 = evc.e.g(r106, r123, "\"");
        r121 = r106.substring(r123, r124);
        r120 = r124 + 1;
    L74:
        r101 = r101 + 1;
    L11:
        r102 = false;
        goto L12
    L10:
        if (r105.equalsIgnoreCase("Pragma") == false) goto L74;
    L75:
        if (r102 == true) goto L77;
        String r212 = null;
    L79:
        return new CacheControl(r104, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r211, r212);
    L77:
        r212 = r103;
        goto L79
    }

    private CacheControl(boolean r100, boolean r101, int r102, int r103, boolean r104, boolean r105, boolean r106, int r107, int r108, boolean r110, boolean r111, boolean r112, @Nullable String r113) {
        this.noCache = r100;
        this.noStore = r101;
        this.maxAgeSeconds = r102;
        this.sMaxAgeSeconds = r103;
        this.isPrivate = r104;
        this.isPublic = r105;
        this.mustRevalidate = r106;
        this.maxStaleSeconds = r107;
        this.minFreshSeconds = r108;
        this.onlyIfCached = r110;
        this.noTransform = r111;
        this.immutable = r112;
        this.headerValue = r113;
    }
}
