package w12;

import com.bytedance.android.livesdk.gift.model.f2;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f557895a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f2 f557896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f557897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f557898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f557899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f557900f;

    static {
        new ArrayList();
        f557895a = new ArrayList();
        f557898d = true;
        f557899e = "webp";
        f557900f = "tplv-obj";
    }

    public static boolean a() {
        f2 r100 = f557896b;
        if (r100 == null) goto L9;
        List<String> r101 = r100.getDomainList();
        if (r101 == null) goto L9;
        if (r101.isEmpty() == true) goto L9;
        return true;
    L9:
        return false;
    }

    public static String b() {
        String r100 = f557899e;
        if (r100 == null) goto L9;
        if (r100.length() <= 1) goto L9;
        return f557899e;
    L9:
        if (f557897c == false) goto L12;
        return "webp";
    L12:
        f2 r101 = f557896b;
        if (r101 == null) goto L19;
        Map<String, String> r102 = r101.getDefaultParams();
        if (r102 == null) goto L21;
        String r103 = r102.get(SubInfo.KEY_FORMAT);
        if (r103 == null) goto L22;
        return r103;
    L22:
        return LoadParams.ImageFormat.PNG;
    L21:
        return LoadParams.ImageFormat.PNG;
    L19:
        return LoadParams.ImageFormat.PNG;
    }

    public static String c() {
        String r100 = f557900f;
        if (r100 != null) goto L5;
    L8:
        f2 r101 = f557896b;
        if (r101 == null) goto L15;
        Map<String, String> r102 = r101.getDefaultParams();
        if (r102 == null) goto L17;
        String r103 = r102.get("tpl");
        if (r103 == null) goto L18;
        return r103;
    L18:
        return "tplv-obj";
    L17:
        return "tplv-obj";
    L15:
        return "tplv-obj";
    L5:
        if (r100.length() <= 1) goto L8;
        return f557900f;
    }
}
