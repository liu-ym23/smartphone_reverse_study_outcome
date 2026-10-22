package com.ss.ttvideoengine.source;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes35.dex */
public class DirectUrlSource implements StrategySource {
    public static final int KEY_LITE_EDITION = 1;
    private static final int KEY_PRO_EDITION = 2;
    private final int codecStrategy;
    private final boolean smartUrlEnabled;
    private final int smartUrlVersion;
    private final Object tag;
    private final List<UrlItem> urlItems;
    private final String vid;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.source.DirectUrlSource$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private int codecStrategy;
        private final List<UrlItem> items;
        private boolean smartUrlEnabled;
        private int smartUrlVersion;
        private Object tag;
        private String vid;

        public DirectUrlSource build() {
            if (this.items.isEmpty() == true) goto L7;
            return new DirectUrlSource(this, null);
        L7:
            throw new IllegalArgumentException("items is empty");
        }

        public Builder() {
            this.items = new ArrayList();
            this.smartUrlVersion = 1;
        }

        public static /* synthetic */ String access$000(Builder r100) {
            return r100.vid;
        }

        public static /* synthetic */ List access$100(Builder r100) {
            return r100.items;
        }

        public static /* synthetic */ int access$200(Builder r100) {
            return r100.codecStrategy;
        }

        public static /* synthetic */ boolean access$300(Builder r100) {
            return r100.smartUrlEnabled;
        }

        public static /* synthetic */ int access$400(Builder r100) {
            return r100.smartUrlVersion;
        }

        public static /* synthetic */ Object access$500(Builder r100) {
            return r100.tag;
        }

        public Builder addItem(UrlItem r100) {
            if (r100 == null) goto L6;
            this.items.add(r100);
            return this;
        L6:
            throw new NullPointerException("urlItem = null");
        }

        public Builder setCodecStrategy(int r100) {
            this.codecStrategy = r100;
            return this;
        }

        public Builder setSmartUrlEnabled(boolean r100) {
            this.smartUrlEnabled = r100;
            return this;
        }

        public Builder setSmartUrlVersion(int r100) {
            this.smartUrlVersion = r100;
            return this;
        }

        public Builder setTag(Object r100) {
            this.tag = r100;
            return this;
        }

        public Builder setVid(String r100) {
            this.vid = r100;
            return this;
        }
    }

    public static class UrlItem {
        private final int bitrate;
        private final String cacheKey;
        private final String encodeType;
        private final String format;
        private final String playAuth;
        private final long urlExpiredTime;
        private final String[] urlExpires;
        private final String[] urls;

        public static class Builder {
            private int bitrate;
            private String cacheKey;
            private String encodeType;
            private String format;
            private String playAuth;
            private long urlExpiredTime;
            private String[] urlExpires;
            private String[] urls;

            public UrlItem build() {
                checkUrls(this.urls);
                return new UrlItem(this, null);
            }

            public Builder() {
                this.bitrate = -1;
            }

            public Builder(UrlItem r100) {
                this.bitrate = -1;
                this.urls = UrlItem.access$1500(r100);
                this.urlExpires = UrlItem.access$1600(r100);
                this.urlExpiredTime = UrlItem.access$1700(r100);
                this.cacheKey = UrlItem.access$1800(r100);
                this.playAuth = UrlItem.access$1900(r100);
                this.encodeType = UrlItem.access$600(r100);
                this.format = UrlItem.access$2000(r100);
                this.bitrate = UrlItem.access$2100(r100);
            }

            public static /* synthetic */ String access$1000(Builder r100) {
                return r100.cacheKey;
            }

            public static /* synthetic */ String access$1100(Builder r100) {
                return r100.playAuth;
            }

            public static /* synthetic */ String access$1200(Builder r100) {
                return r100.encodeType;
            }

            public static /* synthetic */ String access$1300(Builder r100) {
                return r100.format;
            }

            public static /* synthetic */ int access$1400(Builder r100) {
                return r100.bitrate;
            }

            public static /* synthetic */ String[] access$700(Builder r100) {
                return r100.urls;
            }

            public static /* synthetic */ String[] access$800(Builder r100) {
                return r100.urlExpires;
            }

            public static /* synthetic */ long access$900(Builder r100) {
                return r100.urlExpiredTime;
            }

            private static void checkUrls(String[] r100) {
                if (r100 == null) goto L13;
                if (r100.length == 0) goto L11;
                if (TextUtils.isEmpty(r100[0]) == true) goto L9;
                return;
            L9:
                throw new IllegalArgumentException("urls[0] = null");
            L11:
                throw new IllegalArgumentException("urls is empty");
            L13:
                throw new NullPointerException("urls = null");
            }

            public Builder setBitrate(int r100) {
                this.bitrate = r100;
                return this;
            }

            public Builder setCacheKey(String r100) {
                this.cacheKey = r100;
                return this;
            }

            public Builder setEncodeType(String r100) {
                this.encodeType = r100;
                return this;
            }

            public Builder setFormat(String r100) {
                this.format = r100;
                return this;
            }

            public Builder setPlayAuth(String r100) {
                this.playAuth = r100;
                return this;
            }

            public Builder setUrl(String r100) {
                if (r100 == null) goto L6;
                this.urls = new String[]{r100};
                return this;
            L6:
                throw new NullPointerException("url = null");
            }

            public Builder setUrlExpire(String r100) {
                if (r100 == null) goto L6;
                this.urlExpires = new String[]{r100};
                return this;
            L6:
                throw new NullPointerException("expire = null");
            }

            public Builder setUrlExpiredTime(long r100) {
                this.urlExpiredTime = r100;
                return this;
            }

            public Builder setUrlExpires(String[] r100) {
                this.urlExpires = r100;
                return this;
            }

            public Builder setUrls(String[] r100) {
                checkUrls(r100);
                this.urls = r100;
                return this;
            }
        }

        public String getUrl() {
            return this.urls[0];
        }

        public String getUrlExpire() {
            String[] r100 = this.urlExpires;
            if (r100 != null) goto L5;
            return null;
        L5:
            return r100[0];
        }

        public String toString() {
            return "UrlItem{urls=" + Arrays.toString(this.urls) + ", urlExpires=" + Arrays.toString(this.urlExpires) + ", urlExpiredTime=" + this.urlExpiredTime + ", cacheKey='" + this.cacheKey + "', playAuth='" + this.playAuth + "', encodeType='" + this.encodeType + "', format='" + this.format + "', bitrate=" + this.bitrate + '}';
        }

        public int getBitrate() {
            return this.bitrate;
        }

        public String getCacheKey() {
            return this.cacheKey;
        }

        public String getEncodeType() {
            return this.encodeType;
        }

        public String getFormat() {
            return this.format;
        }

        public String getPlayAuth() {
            return this.playAuth;
        }

        public long getUrlExpiredTime() {
            return this.urlExpiredTime;
        }

        public String[] getUrlExpires() {
            return this.urlExpires;
        }

        public String[] getUrls() {
            return this.urls;
        }

        private UrlItem(Builder r100) {
            Builder.access$700(r100);
            this.urls = Builder.access$700(r100);
            this.urlExpires = Builder.access$800(r100);
            this.urlExpiredTime = Builder.access$900(r100);
            this.cacheKey = Builder.access$1000(r100);
            this.playAuth = Builder.access$1100(r100);
            this.encodeType = Builder.access$1200(r100);
            this.format = Builder.access$1300(r100);
            this.bitrate = Builder.access$1400(r100);
        }

        public static /* synthetic */ String[] access$1500(UrlItem r100) {
            return r100.urls;
        }

        public static /* synthetic */ String[] access$1600(UrlItem r100) {
            return r100.urlExpires;
        }

        public static /* synthetic */ long access$1700(UrlItem r100) {
            return r100.urlExpiredTime;
        }

        public static /* synthetic */ String access$1800(UrlItem r100) {
            return r100.cacheKey;
        }

        public static /* synthetic */ String access$1900(UrlItem r100) {
            return r100.playAuth;
        }

        public static /* synthetic */ String access$2000(UrlItem r100) {
            return r100.format;
        }

        public static /* synthetic */ int access$2100(UrlItem r100) {
            return r100.bitrate;
        }

        public static /* synthetic */ String access$600(UrlItem r100) {
            return r100.encodeType;
        }

        public /* synthetic */ UrlItem(Builder r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    @Override // com.ss.ttvideoengine.source.Source
    public final /* synthetic */ boolean isCodecStrategyValid() {
        return Source.CC.$default$isCodecStrategyValid(this);
    }

    public List<UrlItem> allItems() {
        return Collections.unmodifiableList(this.urlItems);
    }

    public UrlItem firstItem() {
        if (this.urlItems.isEmpty() == false) goto L6;
        return null;
    L6:
        return (UrlItem) ListProtector.get(this.urlItems, 0);
    }

    public boolean isEmpty() {
        return this.urlItems.isEmpty();
    }

    public boolean isSmartUrlValid() {
        if (this.smartUrlEnabled == false) goto L8;
        int r100 = this.smartUrlVersion;
        if (r100 == 2) goto L10;
        if (r100 != 1) goto L8;
        return true;
    L10:
        return true;
    L8:
        return false;
    }

    public String toString() {
        return "DirectUrlSource{vid='" + this.vid + "', urlItems=" + this.urlItems + ", codecStrategy=" + this.codecStrategy + ", smartUrlEnabled=" + this.smartUrlEnabled + ", smartUrlVersion=" + this.smartUrlVersion + '}';
    }

    @Override // com.ss.ttvideoengine.source.Source
    public int codecStrategy() {
        return this.codecStrategy;
    }

    public boolean isSmartUrlEnabled() {
        return this.smartUrlEnabled;
    }

    public int smartUrlVersion() {
        return this.smartUrlVersion;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public Object tag() {
        return this.tag;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public Source.Type type() {
        return Source.Type.DIRECT_URL_SOURCE;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public String vid() {
        return this.vid;
    }

    private DirectUrlSource(Builder r100) {
        ArrayList r101 = new ArrayList();
        this.urlItems = r101;
        if (Builder.access$000(r100) != null) goto L5;
        String r102 = UUID.randomUUID().toString();
    L6:
        this.vid = r102;
        r101.addAll(Builder.access$100(r100));
        this.codecStrategy = Builder.access$200(r100);
        this.smartUrlEnabled = Builder.access$300(r100);
        this.smartUrlVersion = Builder.access$400(r100);
        this.tag = Builder.access$500(r100);
        return;
    L5:
        r102 = Builder.access$000(r100);
        goto L6
    }

    public UrlItem findItemByEncodeType(String r100) {
        Iterator<UrlItem> r101 = this.urlItems.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        UrlItem r102 = r101.next();
        if (TextUtils.equals(UrlItem.access$600(r102), r100) == false) goto L4;
        return r102;
    L8:
        return null;
    }

    public /* synthetic */ DirectUrlSource(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
