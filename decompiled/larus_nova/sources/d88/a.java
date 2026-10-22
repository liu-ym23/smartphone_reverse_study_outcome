package d88;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.math.BigInteger;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f467435a = 0;

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        return StringsKt.padStart(new BigInteger(1, MessageDigest.getInstance("MD5").digest(r100.getBytes(Charsets.UTF_8))).toString(16), 32, '0');
    }
}
