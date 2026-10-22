package n66;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.t;
import com.bytedance.ies.xbridge.v;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReadableArray f518164a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f518165a = null;

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
            f518165a = r100;
        }
    }

    @Override // com.bytedance.ies.xbridge.v
    public final int size() {
        return this.f518164a.size();
    }

    @Override // com.bytedance.ies.xbridge.v
    public final List<Object> toList() {
        return this.f518164a.toArrayList();
    }

    public c(ReadableArray r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f518164a = r100;
    }

    @Override // com.bytedance.ies.xbridge.v
    public final t get(int r100) {
        return new n66.a(this.f518164a.getDynamic(r100));
    }

    @Override // com.bytedance.ies.xbridge.v
    public final v getArray(int r100) {
        ReadableArray r101 = this.f518164a.getArray(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new c(r101);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final boolean getBoolean(int r100) {
        return this.f518164a.getBoolean(r100);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final double getDouble(int r100) {
        return this.f518164a.getDouble(r100);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final int getInt(int r100) {
        return this.f518164a.getInt(r100);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final XReadableMap getMap(int r100) {
        ReadableMap r101 = this.f518164a.getMap(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new d(r101);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final String getString(int r100) {
        return this.f518164a.getString(r100);
    }

    @Override // com.bytedance.ies.xbridge.v
    public XReadableType getType(int r100) {
        ReadableType r101 = this.f518164a.getType(r100);
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
        r102 = a.f518165a[r101.ordinal()];
        goto L6
    }
}
