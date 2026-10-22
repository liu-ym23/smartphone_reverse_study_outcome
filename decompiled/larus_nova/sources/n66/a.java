package n66;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.t;
import com.bytedance.ies.xbridge.v;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f6a.a f518161a;

    /* JADX INFO: renamed from: n66.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C6902a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f518162a = null;

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
            f518162a = r100;
        }
    }

    @Override // com.bytedance.ies.xbridge.t
    public final v asArray() {
        ReadableArray r100 = this.f518161a.asArray();
        if (r100 != null) goto L6;
        return null;
    L6:
        return new c(r100);
    }

    @Override // com.bytedance.ies.xbridge.t
    public final boolean asBoolean() {
        return this.f518161a.asBoolean();
    }

    @Override // com.bytedance.ies.xbridge.t
    public final double asDouble() {
        return this.f518161a.asDouble();
    }

    @Override // com.bytedance.ies.xbridge.t
    public final int asInt() {
        return this.f518161a.asInt();
    }

    @Override // com.bytedance.ies.xbridge.t
    public final XReadableMap asMap() {
        ReadableMap r100 = this.f518161a.asMap();
        if (r100 != null) goto L6;
        return null;
    L6:
        return new d(r100);
    }

    @Override // com.bytedance.ies.xbridge.t
    public final String asString() {
        return this.f518161a.asString();
    }

    @Override // com.bytedance.ies.xbridge.t
    public XReadableType getType() {
        ReadableType r100 = this.f518161a.getType();
        if (r100 != null) goto L5;
        int r101 = -1;
    L6:
        switch(r101) {
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
        r101 = C6902a.f518162a[r100.ordinal()];
        goto L6
    }

    public a(f6a.a r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f518161a = r100;
    }
}
