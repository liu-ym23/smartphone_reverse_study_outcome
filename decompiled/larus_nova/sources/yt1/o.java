package yt1;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.dsl.api.DSLType;
import com.bytedance.android.livesdkapi.depend.model.live.DslTypeInt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f569030e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f569031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f569032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f569033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f569034d;

    public static final class a {
        public a() {
        }

        public static o b(LiveDSLModel r100) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            long r101 = r100.getDslType();
            if (r101 != DslTypeInt.DslTypeSlice.getValue()) goto L6;
            String r102 = DSLType.Slice;
        L13:
            if (Intrinsics.areEqual(r102, "Lynx") == true) goto L15;
        L19:
            String r103 = r100.getUrl();
            if (r103 == null) goto L27;
            if (r103.length() <= 0) goto L24;
            boolean r104 = true;
        L25:
            if (r104 != true) goto L27;
        L28:
            StringBuilder r105 = new StringBuilder();
            String r106 = r100.getUrl();
            if (r106 == null) goto L32;
            String r107 = String.valueOf(r106.hashCode());
            if (r107 == null) goto L32;
        L33:
            r105.append(r107);
            r105.append("-");
            r105.append(String.valueOf(r100.getVersion()));
            String r108 = r105.toString();
        L35:
            String r109 = String.valueOf(r100.getId());
            String r110 = r100.getSliceContent();
            String r111 = r100.getUrl();
            Intrinsics.checkNotNullParameter(r109, "id");
            Intrinsics.checkNotNullParameter(r108, "hashCode");
            Intrinsics.checkNotNullParameter(r102, "type");
            o r112 = new o(new q(r109, r108), new p(r110, r111), r102);
            LiveDSLModel.ExtraInfo r113 = r100.getExtra();
            if (r113 == null) goto L38;
            e r114 = new e();
            r114.f569028b = r113.getWidth();
            r114.f569027a = r113.getHeight();
            Unit r115 = Unit.INSTANCE;
            r112.f569031a = r114;
        L38:
            return r112;
        L32:
            r107 = String.valueOf(r100.getId());
            goto L33
        L24:
            r104 = false;
        L27:
            if (r100.getVersion() > 0) goto L28;
            r108 = "";
            goto L35
        L15:
            if (v.a() == false) goto L19;
            throw new Exception("not support lynx now.");
        L6:
            if (r101 != DslTypeInt.DslTypeLynxAir.getValue()) goto L9;
            r102 = DSLType.LynxAir;
            goto L13
        L9:
            if (r101 != DslTypeInt.DslTypeLynx.getValue()) goto L11;
            r102 = "Lynx";
            goto L13
        L11:
            r102 = "Unknown";
            goto L13
        }

        public static o a(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "hashCode");
            Intrinsics.checkNotNullParameter(r102, "content");
            return new o(new q(r100, r101), new p(r102, null, 2), DSLType.Slice);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L12;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f569032b, r101.f569032b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f569033c, r101.f569033c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f569034d, r101.f569034d) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        q r100 = this.f569032b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        p r104 = this.f569033c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f569034d;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TemplateData(key=" + this.f569032b + ", source=" + this.f569033c + ", type=" + this.f569034d + ")";
    }

    static {
        f569030e = new a();
    }

    public final String getType() {
        return this.f569034d;
    }

    public o(q r100, p r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "type");
        this.f569032b = r100;
        this.f569033c = r101;
        this.f569034d = r102;
    }
}
