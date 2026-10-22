package com.larksuite.component.ud.radius;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/larksuite/component/ud/radius/UDRadius;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "getRadiusSize", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, UserProfileEvent.POSITION_NONE, "XS", ExifInterface.LATITUDE_SOUTH, "M", "L", "XL", "XXL", "ROUND", "chameleon-base_release"}, k = 1, mv = {1, 7, 1})
public final enum UDRadius extends Enum<UDRadius> {
    public static final a Companion = null;
    public static final UDRadius L = null;
    public static final UDRadius M = null;
    public static final UDRadius NONE = null;
    public static final UDRadius ROUND = null;
    public static final UDRadius S = null;
    public static final UDRadius XL = null;
    public static final UDRadius XS = null;
    public static final UDRadius XXL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDRadius[] f284039a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f284040a = null;

        static {
            int[] r100 = new int[UDRadius.values().length];
            r100[UDRadius.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[UDRadius.XS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[UDRadius.S.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[UDRadius.M.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[UDRadius.L.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[UDRadius.XL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[UDRadius.XXL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[UDRadius.ROUND.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f284040a = r100;
        }
    }

    public static UDRadius valueOf(String r100) {
        return (UDRadius) r27.a.a(UDRadius.class, r100);
    }

    public static UDRadius[] values() {
        return (UDRadius[]) f284039a.clone();
    }

    static {
        UDRadius r100 = new UDRadius(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        UDRadius r101 = new UDRadius("XS", 1, 1);
        XS = r101;
        UDRadius r102 = new UDRadius(ExifInterface.LATITUDE_SOUTH, 2, 2);
        S = r102;
        UDRadius r103 = new UDRadius("M", 3, 3);
        M = r103;
        UDRadius r104 = new UDRadius("L", 4, 4);
        L = r104;
        UDRadius r105 = new UDRadius("XL", 5, 5);
        XL = r105;
        UDRadius r110 = new UDRadius("XXL", 6, 6);
        XXL = r110;
        UDRadius r111 = new UDRadius("ROUND", 7, 6);
        ROUND = r111;
        f284039a = new UDRadius[]{r100, r101, r102, r103, r104, r105, r110, r111};
        Companion = new a();
    }

    public final int getValue() {
        return this.value;
    }

    public final int getRadiusSize(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        switch(b.f284040a[ordinal()]) {
            case 1: goto L13;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        return -1;
    L13:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    L16:
        return qz7.a.a(r100, R.dimen.ud_radius_xxl);
    L17:
        return qz7.a.a(r100, R.dimen.ud_radius_xl);
    L18:
        return qz7.a.a(r100, R.dimen.ud_radius_l);
    L19:
        return qz7.a.a(r100, R.dimen.ud_radius_m);
    L20:
        return qz7.a.a(r100, R.dimen.ud_radius_s);
    L21:
        return qz7.a.a(r100, R.dimen.ud_radius_xs);
    }

    public UDRadius(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
