package zh0;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f572119a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        if (r100.containsKey("Extra_Radio_Bgtype_Converter") == true) goto L5;
    L17:
        return false;
    L5:
        if (r100.containsKey("Extra_Radio_Image_Uri_Converter") == false) goto L17;
        if (r100.containsKey("Extra_Radio_Single_Static_Imagemodel_Converter") == false) goto L17;
        if (r100.containsKey("Extra_Radio_Static_Imagemodel_Converter") == false) goto L17;
        if (r100.containsKey("Extra_Radio_Animated_Imagemodel_Converter") == false) goto L17;
        if (r100.containsKey("Extra_Radio_IMAGE_TYPE") == false) goto L17;
        if (r100.containsKey("Extra_Radio_Public_Color") == false) goto L17;
        return true;
    }

    @JvmStatic
    public static final String[] b(py.k r100) {
        String[] r101 = new String[5];
        String r102 = "";
        if (r100 == null) goto L6;
        String r103 = r100.getAvgColor();
        if (r103 == null) goto L6;
    L7:
        r101[0] = r103;
        if (r100 == null) goto L11;
        String r104 = r100.getUri();
        if (r104 == null) goto L11;
    L12:
        r101[1] = r104;
        if (r100 == null) goto L22;
        List<String> r105 = r100.getUrls();
        if (r105 == null) goto L22;
        if (CollectionsKt.getLastIndex(r105) < 0) goto L19;
        Object r106 = ListProtector.get(r105, 0);
    L20:
        String r107 = (String) r106;
        if (r107 == null) goto L22;
    L23:
        r101[2] = r107;
        if (r100 == null) goto L33;
        List<String> r108 = r100.getUrls();
        if (r108 == null) goto L33;
        if (1 > CollectionsKt.getLastIndex(r108)) goto L30;
        Object r109 = ListProtector.get(r108, 1);
    L31:
        String r110 = (String) r109;
        if (r110 == null) goto L33;
    L34:
        r101[3] = r110;
        if (r100 == null) goto L46;
        List<String> r111 = r100.getUrls();
        if (r111 == null) goto L46;
        if (2 > CollectionsKt.getLastIndex(r111)) goto L41;
        Object r112 = ListProtector.get(r111, 2);
    L42:
        String r113 = (String) r112;
        if (r113 == null) goto L46;
        r102 = r113;
        goto L46
    L41:
        r112 = "";
    L46:
        r101[4] = r102;
        return r101;
    L30:
        r109 = "";
    L33:
        r110 = "";
        goto L34
    L19:
        r106 = "";
    L22:
        r107 = "";
    L11:
        r104 = "";
    L6:
        r103 = "";
        goto L7
    }

    @JvmStatic
    public static final Bundle c(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceLiveTheme");
        Bundle r101 = new Bundle();
        r101.putInt("Extra_Radio_IMAGE_TYPE", r100.getImageType());
        r101.putInt("Extra_Radio_Bgtype_Converter", r100.getBgType());
        String r102 = r100.getImageUri();
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.putString("Extra_Radio_Image_Uri_Converter", r102);
        r101.putStringArray("Extra_Radio_Single_Static_Imagemodel_Converter", b(r100.getSingleStaticBackground()));
        r101.putStringArray("Extra_Radio_Static_Imagemodel_Converter", b(r100.getStaticBackground()));
        r101.putStringArray("Extra_Radio_Animated_Imagemodel_Converter", b(r100.getAnimatedBackground()));
        String r104 = r100.getPublicScreenColorValue();
        if (r104 == null) goto L9;
        r103 = r104;
    L9:
        r101.putString("Extra_Radio_Public_Color", r103);
        return r101;
    }
}
