package en4;

import com.bytedance.ee.bear.appsetting.host.CcmHostAppSettingMap;
import com.bytedance.ee.bear.appsetting.host.CcmHostConfig;
import com.bytedance.ee.bear.appsetting.host.CcmHostExportConfig;
import com.bytedance.ee.bear.appsetting.host.CcmHostHelpCenterLinkConfig;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.component.appcontext.model.LarkBuildConfig;
import com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean j() {
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L8
        LarkBuildConfig r100 = LarkAppContext.access$getInstance$cp().buildConfig();     // Catch: Throwable -> L8
        if (r100.isOfficeSDK() == false) goto L13;
        if (r100.isUsPackage() == false) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L8:
        th = move-exception;
        tt5.a.l("CcmHostAppSetting", "isDolaHost failed", th);
        return false;
    }

    public static CcmHostConfig b() {
        int r100 = b.f473159a;
        CcmHostConfig r101 = new CcmHostConfig();
        CcmHostExportConfig r102 = new CcmHostExportConfig();
        r102.setDocxExportFormats(CollectionsKt.arrayListOf(new String[]{"image", DocumentType.DOCX_NAME, ExportFileExtension.PDF, "markdown"}));
        r102.setEventSource(41);
        r101.setExport(r102);
        return r101;
    }

    public static CcmHostConfig c() {
        int r100 = c.f473160a;
        CcmHostConfig r101 = new CcmHostConfig();
        CcmHostExportConfig r102 = new CcmHostExportConfig();
        r102.setDocxExportFormats(CollectionsKt.arrayListOf(new String[]{"image", DocumentType.DOCX_NAME, ExportFileExtension.PDF, "txt"}));
        r102.setEventSource(41);
        r101.setExport(r102);
        return r101;
    }

    public static CcmHostConfig d() {
        int r100 = d.f473161a;
        CcmHostConfig r101 = new CcmHostConfig();
        CcmHostExportConfig r102 = new CcmHostExportConfig();
        r102.setDocxExportFormats(CollectionsKt.arrayListOf(new String[]{"image", DocumentType.DOCX_NAME, ExportFileExtension.PDF, "markdown"}));
        r102.setEventSource(15);
        r101.setExport(r102);
        return r101;
    }

    public static CcmHostAppSettingMap e() {
        CcmHostAppSettingMap r100 = new CcmHostAppSettingMap();
        r100.setLark(d());
        r100.setDoubaoPersonal(c());
        r100.setDoubaoEnterprise(b());
        return r100;
    }

    @JvmStatic
    public static final CcmHostConfig f() {
        CcmHostAppSettingMap r100 = (CcmHostAppSettingMap) com.bytedance.ee.bear.appsetting.c.a.f206237a.c(CcmHostAppSettingMap.SETTING_KEY, CcmHostAppSettingMap.class, e());
        if (r100 != null) goto L6;
        r100 = e();
    L6:
        if (k() == false) goto L9;
        String r101 = "doubao_enterprise";
    L13:
        if (Intrinsics.areEqual(r101, "doubao_enterprise") == false) goto L16;
        CcmHostConfig r102 = r100.getDoubaoEnterprise();
    L19:
        if (r102 != null) goto L21;
        r102 = a();
    L21:
        StringBuilder r103 = new StringBuilder("getConfig, hostType=");
        r103.append(r101);
        r103.append(", eventSource=");
        CcmHostExportConfig r104 = r102.getExport();
        Integer r105 = null;
        if (r104 == null) goto L24;
        Integer r106 = r104.getEventSource();
    L25:
        r103.append(r106);
        r103.append(", docxExportFormats=");
        CcmHostExportConfig r107 = r102.getExport();
        if (r107 == null) goto L28;
        ArrayList<String> r108 = r107.getDocxExportFormats();
    L29:
        r103.append(r108);
        tt5.a.h("CcmHostAppSetting", r103.toString());
        CcmHostConfig r109 = a();
        CcmHostExportConfig r110 = r102.getExport();
        CcmHostExportConfig r111 = r109.getExport();
        if (r111 != null) goto L34;
        r111 = a().getExport();
        if (r111 != null) goto L34;
        r111 = new CcmHostExportConfig();
        r111.setEventSource(15);
    L34:
        if (r110 == null) goto L48;
        ArrayList<String> r112 = r110.getDocxExportFormats();
        if (r112 == null) goto L48;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r114 = r112.iterator();
    L39:
        if (r114.hasNext() == false) goto L41;
        r113.add(StringsKt.trim((String) r114.next()).toString().toLowerCase(Locale.ROOT));
        goto L39
    L41:
        ArrayList r115 = new ArrayList();
        Iterator r116 = r113.iterator();
    L43:
        if (r116.hasNext() == false) goto L47;
        Object r117 = r116.next();
        if (e.f473162a.contains((String) r117) == false) goto L43;
        r115.add(r117);
        goto L43
    L47:
        List r118 = CollectionsKt.distinct(r115);
    L49:
        boolean r119 = true;
        if (r110 == null) goto L60;
        Integer r120 = r110.getEventSource();
        if (r120 == null) goto L60;
        if (r120.intValue() <= 0) goto L56;
        boolean r121 = true;
    L57:
        if (r121 == false) goto L59;
        r105 = r120;
    L59:
        if (r105 == null) goto L60;
    L61:
        CcmHostExportConfig r122 = new CcmHostExportConfig();
        List r123 = r118;
        if (r123 != null) goto L64;
    L67:
        if (r119 == false) goto L72;
        Collection r124 = r111.getDocxExportFormats();
        if (r124 != null) goto L71;
        r124 = CollectionsKt.emptyList();
    L71:
        ArrayList<String> r125 = new ArrayList(r124);
    L73:
        r122.setDocxExportFormats(r125);
        r122.setEventSource(r105);
        CcmHostConfig r126 = new CcmHostConfig();
        r126.setExport(r122);
        Map<String, CcmHostHelpCenterLinkConfig> r127 = r102.getHelpCenter();
        if (r127 != null) goto L76;
        r127 = r109.getHelpCenter();
    L76:
        r126.setHelpCenter(r127);
        return r126;
    L72:
        r125 = new ArrayList(r123);
        goto L73
    L64:
        if (r123.isEmpty() == true) goto L67;
        r119 = false;
        goto L67
    L56:
        r121 = false;
    L60:
        r105 = r111.getEventSource();
    L48:
        r118 = null;
        goto L49
    L28:
        r108 = null;
        goto L29
    L24:
        r106 = null;
        goto L25
    L16:
        if (Intrinsics.areEqual(r101, "doubao_personal") == false) goto L18;
        r102 = r100.getDoubaoPersonal();
        goto L19
    L18:
        r102 = r100.getLark();
        goto L19
    L9:
        if (Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE) == false) goto L11;
        r101 = "doubao_personal";
        goto L13
    L11:
        r101 = "lark";
        goto L13
    }

    public static CcmHostConfig a() {
        if (k() == false) goto L6;
        return b();
    L6:
        if (Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE) == false) goto L9;
        return c();
    L9:
        return d();
    }

    @JvmStatic
    public static final List<String> g() {
        CcmHostExportConfig r100 = f().getExport();
        if (r100 == null) goto L7;
        ArrayList<String> r101 = r100.getDocxExportFormats();
        if (r101 == null) goto L7;
        return r101;
    L7:
        CcmHostExportConfig r102 = a().getExport();
        if (r102 == null) goto L10;
        ArrayList<String> r103 = r102.getDocxExportFormats();
    L11:
        if (r103 == null) goto L13;
        return r103;
    L13:
        return CollectionsKt.emptyList();
    L10:
        r103 = null;
        goto L11
    }

    @JvmStatic
    public static final String h() {
        CcmHostExportConfig r100 = f().getExport();
        if (r100 == null) goto L7;
        Integer r101 = r100.getEventSource();
        if (r101 == null) goto L7;
    L12:
        int r102 = r101.intValue();
    L15:
        return String.valueOf(r102);
    L7:
        CcmHostExportConfig r103 = a().getExport();
        if (r103 == null) goto L10;
        r101 = r103.getEventSource();
    L11:
        if (r101 != null) goto L12;
        r102 = 15;
        goto L15
    L10:
        r101 = null;
        goto L11
    }

    public static boolean k() {
        if (Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE) == true) goto L12;
        return false;
    L12:
        if (((IOfficeAppBaseInfo) LarkContext.spiByDwarf(IOfficeAppBaseInfo.class)).isEnterpriseAccount() != true) goto L14;
        return true;
    L14:
        return false;
    L9:
        th = move-exception;
        tt5.a.l("CcmHostAppSetting", "isDoubaoEnterpriseAccount failed", th);
        return false;
    }

    @JvmStatic
    public static final boolean l() {
        return Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE);
    }

    @JvmStatic
    public static final String i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "pointKey");
        Intrinsics.checkNotNullParameter(r101, "language");
        Intrinsics.checkNotNullParameter(r100, "pointKey");
        Map<String, CcmHostHelpCenterLinkConfig> r102 = f().getHelpCenter();
        if (r102 == null) goto L5;
        CcmHostHelpCenterLinkConfig r103 = r102.get(r100);
    L6:
        if (r103 != null) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(Locale.CHINESE.getLanguage(), r101) == false) goto L13;
        String r104 = r103.getZhUrl();
        if (StringsKt.isBlank(r104) == false) goto L19;
        r104 = r103.getUrl();
    L19:
        if ((!StringsKt.isBlank(r104)) == true) goto L21;
        return null;
    L21:
        return r104;
    L13:
        r104 = r103.getEnUrl();
        if (StringsKt.isBlank(r104) == false) goto L19;
        r104 = r103.getUrl();
        if (StringsKt.isBlank(r104) == false) goto L19;
        r104 = r103.getZhUrl();
        goto L19
    L5:
        r103 = null;
        goto L6
    }
}
