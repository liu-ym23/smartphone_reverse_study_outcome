package n66;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.t;
import com.bytedance.ies.xbridge.u;
import com.bytedance.ies.xbridge.v;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements XReadableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReadableMap f518166a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f518167a = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            r100[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[ReadableType.Array.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[ReadableType.Boolean.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[ReadableType.Map.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[ReadableType.Int.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f518167a = r100;
        }
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final u keyIterator() {
        return new b(this.f518166a.keySetIterator());
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final Map<String, Object> toMap() {
        return this.f518166a.toHashMap();
    }

    public d(ReadableMap r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f518166a = r100;
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final t get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return new n66.a(this.f518166a.getDynamic(r100));
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final v getArray(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ReadableArray r101 = this.f518166a.getArray(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new c(r101);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final boolean getBoolean(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f518166a.getBoolean(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final double getDouble(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f518166a.getDouble(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final int getInt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f518166a.getInt(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final XReadableMap getMap(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ReadableMap r101 = this.f518166a.getMap(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new d(r101);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final String getString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f518166a.getString(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public XReadableType getType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ReadableType r101 = this.f518166a.getType(r100);
        if (r101 != null) goto L5;
        int r102 = -1;
    L6:
        switch(r102) {
            case 1: goto L15;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            default: goto L16;
        };
    L16:
        return XReadableType.Null;
    L17:
        return XReadableType.Int;
    L18:
        return XReadableType.String;
    L19:
        return XReadableType.Number;
    L20:
        return XReadableType.Map;
    L21:
        return XReadableType.Boolean;
    L22:
        return XReadableType.Array;
    L15:
        return XReadableType.Null;
    L5:
        r102 = a.f518167a[r101.ordinal()];
        goto L6
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final boolean hasKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f518166a.hasKey(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final boolean isNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f518166a.isNull(r100);
    }
}
