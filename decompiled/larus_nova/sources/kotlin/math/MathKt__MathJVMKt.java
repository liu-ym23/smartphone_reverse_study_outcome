package kotlin.math;

import androidx.camera.video.AudioStats;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b8\u001a\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010!\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010!\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010#\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010#\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010$\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010$\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010%\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010%\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010&\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010&\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010'\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010'\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010(\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010(\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010)\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010)\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010*\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010*\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0018\u0010+\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0007\u001a\u0018\u0010+\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0007\u001a\u0011\u0010-\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u0010.\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0019\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0087\b\u001a\u0019\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0087\b\u001a\u0019\u00102\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0087\b\u001a\u0019\u00102\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0087\b\u001a\u0019\u00102\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0087\b\u001a\u0019\u00102\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0087\b\u001a\u0011\u00103\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00103\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00104\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00104\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00105\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00105\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00106\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00106\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00107\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00107\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00108\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00108\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u00109\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u00109\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0015\u0010:\u001a\u00020\u0001*\u00020\u00012\u0006\u0010;\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010:\u001a\u00020\u0006*\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0087\b\u001a\r\u0010<\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010<\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u0015\u0010=\u001a\u00020\u0001*\u00020\u00012\u0006\u0010>\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010=\u001a\u00020\u0006*\u00020\u00062\u0006\u0010>\u001a\u00020\u0006H\u0087\b\u001a\r\u0010?\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010?\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\f\u0010A\u001a\u00020\t*\u00020\u0001H\u0007\u001a\f\u0010A\u001a\u00020\t*\u00020\u0006H\u0007\u001a\f\u0010B\u001a\u00020\f*\u00020\u0001H\u0007\u001a\f\u0010B\u001a\u00020\f*\u00020\u0006H\u0007\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\tH\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0087\b\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010\u0000\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0007\u001a\u0004\b\u0004\u0010\b\"\u001f\u0010\u0000\u001a\u00020\t*\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\n\u001a\u0004\b\u0004\u0010\u000b\"\u001f\u0010\u0000\u001a\u00020\f*\u00020\f8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\r\u001a\u0004\b\u0004\u0010\u000e\"\u001f\u0010\u000f\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005\"\u001f\u0010\u000f\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0005\"\u001f\u0010\u0013\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\b¨\u0006D"}, d2 = {"absoluteValue", "", "getAbsoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "", "(F)V", "(F)F", "", "(I)V", "(I)I", "", "(J)V", "(J)J", "sign", "getSign$annotations", "getSign", "(J)I", "ulp", "getUlp$annotations", "getUlp", "abs", "x", OfficeSDKRequestTag.KEY_NEW_USER, "acos", "acosh", "asin", "asinh", "atan", "atan2", "y", "atanh", "cbrt", "ceil", "cos", "cosh", OnekeyLoginConstants.CU_KEY_TOKEN_EXPIRES, "expm1", "floor", "hypot", "ln", "ln1p", "log", "base", "log10", "log2", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "round", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "IEEErem", "divisor", "nextDown", "nextTowards", RemoteMessageConst.TO, "nextUp", "pow", "roundToInt", "roundToLong", "withSign", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/math/MathKt")
class MathKt__MathJVMKt extends MathKt__MathHKt {
    public MathKt__MathJVMKt() {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(double r100) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(float r100) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(int r100) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(long r100) {
    }

    public static /* synthetic */ void getSign$annotations(double r100) {
    }

    public static /* synthetic */ void getSign$annotations(float r100) {
    }

    public static /* synthetic */ void getSign$annotations(int r100) {
    }

    public static /* synthetic */ void getSign$annotations(long r100) {
    }

    public static /* synthetic */ void getUlp$annotations(double r100) {
    }

    public static /* synthetic */ void getUlp$annotations(float r100) {
    }

    private static final double abs(double r100) {
        return Math.abs(r100);
    }

    private static final float acos(float r100) {
        return (float) Math.acos(r100);
    }

    public static double acosh(double r100) {
        if (r100 >= 1.0d) goto L6;
        return Double.NaN;
    L6:
        if (r100 > Constants.upper_taylor_2_bound) goto L17;
        double r101 = 1;
        double r102 = r100 - r101;
        if (r102 >= Constants.taylor_n_bound) goto L18;
        double r103 = Math.sqrt(r102);
        if (r103 < Constants.taylor_2_bound) goto L15;
        r103 = r103 - (((r103 * r103) * r103) / ((double) 12));
    L15:
        return r103 * Math.sqrt(2.0d);
    L18:
        return Math.log(r100 + Math.sqrt((r100 * r100) - r101));
    L17:
        return Math.log(r100) + Constants.LN2;
    }

    private static final float asin(float r100) {
        return (float) Math.asin(r100);
    }

    public static double asinh(double r100) {
        double r101 = Constants.taylor_n_bound;
        if (r100 < r101) goto L12;
        if (r100 <= Constants.upper_taylor_n_bound) goto L20;
        if (r100 > Constants.upper_taylor_2_bound) goto L18;
        double r102 = r100 * ((double) 2);
        return Math.log(r102 + (((double) 1) / r102));
    L18:
        return Math.log(r100) + Constants.LN2;
    L20:
        return Math.log(r100 + Math.sqrt((r100 * r100) + ((double) 1)));
    L12:
        if (r100 > (-r101)) goto L15;
        return -asinh(-r100);
    L15:
        if (Math.abs(r100) >= Constants.taylor_2_bound) goto L17;
        return r100;
    L17:
        return r100 - (((r100 * r100) * r100) / ((double) 6));
    }

    private static final float atan(float r100) {
        return (float) Math.atan(r100);
    }

    public static double atanh(double r100) {
        if (Math.abs(r100) < Constants.taylor_n_bound) goto L5;
        double r101 = 1;
        return Math.log((r101 + r100) / (r101 - r100)) / ((double) 2);
    L5:
        if (Math.abs(r100) > Constants.taylor_2_bound) goto L7;
        return r100;
    L7:
        return r100 + (((r100 * r100) * r100) / ((double) 3));
    }

    private static final float cbrt(float r100) {
        return (float) Math.cbrt(r100);
    }

    private static final float ceil(float r100) {
        return (float) Math.ceil(r100);
    }

    private static final float cos(float r100) {
        return (float) Math.cos(r100);
    }

    private static final float cosh(float r100) {
        return (float) Math.cosh(r100);
    }

    private static final float exp(float r100) {
        return (float) Math.exp(r100);
    }

    private static final float expm1(float r100) {
        return (float) Math.expm1(r100);
    }

    private static final float floor(float r100) {
        return (float) Math.floor(r100);
    }

    private static final double getAbsoluteValue(double r100) {
        return Math.abs(r100);
    }

    private static final double getSign(double r100) {
        return Math.signum(r100);
    }

    private static final double getUlp(double r100) {
        return Math.ulp(r100);
    }

    private static final float ln(float r100) {
        return (float) Math.log(r100);
    }

    private static final float ln1p(float r100) {
        return (float) Math.log1p(r100);
    }

    private static final float log10(float r100) {
        return (float) Math.log10(r100);
    }

    public static final float log2(float r100) {
        return (float) (Math.log(r100) / Constants.LN2);
    }

    private static final double nextDown(double r100) {
        return Math.nextAfter(r100, Double.NEGATIVE_INFINITY);
    }

    private static final double nextUp(double r100) {
        return Math.nextUp(r100);
    }

    private static final float round(float r100) {
        return (float) Math.rint(r100);
    }

    public static int roundToInt(double r100) {
        if (Double.isNaN(r100) == true) goto L13;
        if (r100 <= 2.147483647E9d) goto L8;
        return Integer.MAX_VALUE;
    L8:
        if (r100 >= (-2.147483648E9d)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) Math.round(r100);
    L13:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static long roundToLong(double r100) {
        if (Double.isNaN(r100) == true) goto L7;
        return Math.round(r100);
    L7:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    private static final double sign(double r100) {
        return Math.signum(r100);
    }

    private static final float sin(float r100) {
        return (float) Math.sin(r100);
    }

    private static final float sinh(float r100) {
        return (float) Math.sinh(r100);
    }

    private static final float sqrt(float r100) {
        return (float) Math.sqrt(r100);
    }

    private static final float tan(float r100) {
        return (float) Math.tan(r100);
    }

    private static final float tanh(float r100) {
        return (float) Math.tanh(r100);
    }

    public static float truncate(float r100) {
        if (Float.isNaN(r100) == false) goto L5;
        return r100;
    L5:
        if (Float.isInfinite(r100) == false) goto L8;
        return r100;
    L8:
        if (r100 <= 0.0f) goto L10;
        double r101 = Math.floor(r100);
    L12:
        return (float) r101;
    L10:
        r101 = Math.ceil(r100);
        goto L12
    }

    private static final float abs(float r100) {
        return Math.abs(r100);
    }

    private static final double acos(double r100) {
        return Math.acos(r100);
    }

    private static final float acosh(float r100) {
        return (float) acosh(r100);
    }

    private static final double asin(double r100) {
        return Math.asin(r100);
    }

    private static final float asinh(float r100) {
        return (float) asinh(r100);
    }

    private static final double atan(double r100) {
        return Math.atan(r100);
    }

    private static final float atanh(float r100) {
        return (float) atanh(r100);
    }

    private static final double cbrt(double r100) {
        return Math.cbrt(r100);
    }

    private static final double ceil(double r100) {
        return Math.ceil(r100);
    }

    private static final double cos(double r100) {
        return Math.cos(r100);
    }

    private static final double cosh(double r100) {
        return Math.cosh(r100);
    }

    private static final double exp(double r100) {
        return Math.exp(r100);
    }

    private static final double expm1(double r100) {
        return Math.expm1(r100);
    }

    private static final double floor(double r100) {
        return Math.floor(r100);
    }

    private static final float getAbsoluteValue(float r100) {
        return Math.abs(r100);
    }

    private static final float getSign(float r100) {
        return Math.signum(r100);
    }

    private static final float getUlp(float r100) {
        return Math.ulp(r100);
    }

    private static final double ln(double r100) {
        return Math.log(r100);
    }

    private static final double ln1p(double r100) {
        return Math.log1p(r100);
    }

    private static final double log10(double r100) {
        return Math.log10(r100);
    }

    public static double log2(double r100) {
        return Math.log(r100) / Constants.LN2;
    }

    private static final float nextDown(float r100) {
        return Math.nextAfter(r100, Double.NEGATIVE_INFINITY);
    }

    private static final float nextUp(float r100) {
        return Math.nextUp(r100);
    }

    private static final double round(double r100) {
        return Math.rint(r100);
    }

    public static int roundToInt(float r100) {
        if (Float.isNaN(r100) == true) goto L7;
        return Math.round(r100);
    L7:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static long roundToLong(float r100) {
        return roundToLong(r100);
    }

    private static final float sign(float r100) {
        return Math.signum(r100);
    }

    private static final double sin(double r100) {
        return Math.sin(r100);
    }

    private static final double sinh(double r100) {
        return Math.sinh(r100);
    }

    private static final double sqrt(double r100) {
        return Math.sqrt(r100);
    }

    private static final double tan(double r100) {
        return Math.tan(r100);
    }

    private static final double tanh(double r100) {
        return Math.tanh(r100);
    }

    public static double truncate(double r100) {
        if (Double.isNaN(r100) == false) goto L5;
        return r100;
    L5:
        if (Double.isInfinite(r100) == false) goto L8;
        return r100;
    L8:
        if (r100 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        return Math.floor(r100);
    L11:
        return Math.ceil(r100);
    }

    private static final int abs(int r100) {
        return Math.abs(r100);
    }

    private static final int getAbsoluteValue(int r100) {
        return Math.abs(r100);
    }

    public static int getSign(int r100) {
        return Integer.signum(r100);
    }

    private static final long abs(long r100) {
        return Math.abs(r100);
    }

    private static final long getAbsoluteValue(long r100) {
        return Math.abs(r100);
    }

    public static int getSign(long r100) {
        return Long.signum(r100);
    }

    private static final float IEEErem(float r100, float r101) {
        return (float) Math.IEEEremainder(r100, r101);
    }

    private static final float atan2(float r100, float r101) {
        return (float) Math.atan2(r100, r101);
    }

    private static final float hypot(float r100, float r101) {
        return (float) Math.hypot(r100, r101);
    }

    public static final float log(float r100, float r101) {
        if (r101 > 0.0f) goto L5;
        return Float.NaN;
    L5:
        if (r101 != 1.0f) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L11;
        return Float.NaN;
    L11:
        return (float) (Math.log(r100) / Math.log(r101));
    L7:
        r102 = false;
        goto L8
    }

    private static final double max(double r100, double r101) {
        return Math.max(r100, r101);
    }

    private static final double min(double r100, double r101) {
        return Math.min(r100, r101);
    }

    private static final float nextTowards(float r100, float r101) {
        return Math.nextAfter(r100, r101);
    }

    private static final float pow(float r100, float r101) {
        return (float) Math.pow(r100, r101);
    }

    private static final double withSign(double r100, int r101) {
        return Math.copySign(r100, r101);
    }

    private static final double IEEErem(double r100, double r101) {
        return Math.IEEEremainder(r100, r101);
    }

    private static final double atan2(double r100, double r101) {
        return Math.atan2(r100, r101);
    }

    private static final double hypot(double r100, double r101) {
        return Math.hypot(r100, r101);
    }

    public static double log(double r100, double r101) {
        if (r101 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        return Double.NaN;
    L5:
        if (r101 != 1.0d) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L11;
        return Double.NaN;
    L11:
        return Math.log(r100) / Math.log(r101);
    L7:
        r102 = false;
        goto L8
    }

    private static final float max(float r100, float r101) {
        return Math.max(r100, r101);
    }

    private static final float min(float r100, float r101) {
        return Math.min(r100, r101);
    }

    private static final double nextTowards(double r100, double r101) {
        return Math.nextAfter(r100, r101);
    }

    private static final float pow(float r100, int r101) {
        return (float) Math.pow(r100, r101);
    }

    private static final float withSign(float r100, int r101) {
        return Math.copySign(r100, r101);
    }

    private static final int max(int r100, int r101) {
        return Math.max(r100, r101);
    }

    private static final int min(int r100, int r101) {
        return Math.min(r100, r101);
    }

    private static final double pow(double r100, int r101) {
        return Math.pow(r100, r101);
    }

    private static final double withSign(double r100, double r101) {
        return Math.copySign(r100, r101);
    }

    private static final long max(long r100, long r101) {
        return Math.max(r100, r101);
    }

    private static final long min(long r100, long r101) {
        return Math.min(r100, r101);
    }

    private static final double pow(double r100, double r101) {
        return Math.pow(r100, r101);
    }

    private static final float withSign(float r100, float r101) {
        return Math.copySign(r100, r101);
    }
}
