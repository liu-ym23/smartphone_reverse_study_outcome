package se8;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.common.utility.io.FileUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.trace.CopyContentTypeString;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f541621a = null;

    static {
        f541621a = LazyKt.lazy(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static PolarisFileWrapper a(Context r210, String r211, String r212) {
        String r100 = r211;
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "content");
        String r101 = ((SimpleDateFormat) f541621a.getValue()).format(new Date());
        if (Intrinsics.areEqual(r212, "csv") == false) goto L5;
        String r102 = "sheet_" + r101;
    L6:
        PolarisFileWrapper r103 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        ?? r104 = 0;
        r103 = null;
        r103 = null;
        if (r212 == null) goto L9;
        String r105 = r212.toLowerCase(Locale.getDefault());
    L11:
        if (r105 == null) goto L134;
        String r106 = "cpp";
        switch(r105.hashCode()) {
            case -1351281305: goto L131;
            case -1267903281: goto L127;
            case -1125574399: goto L123;
            case -989164661: goto L119;
            case -973197092: goto L115;
            case -874439239: goto L111;
            case -522285947: goto L108;
            case 99: goto L104;
            case 114: goto L101;
            case 3304: goto L98;
            case 96515: goto L96;
            case 96891: goto L92;
            case 98723: goto L90;
            case 98819: goto L86;
            case 98822: goto L83;
            case 107512: goto L79;
            case 110968: goto L76;
            case 114126: goto L73;
            case 114276: goto L70;
            case 118807: goto L67;
            case 3016404: goto L64;
            case 3075967: goto L60;
            case 3213227: goto L57;
            case 3254818: goto L54;
            case 3271912: goto L51;
            case 3511770: goto L47;
            case 3512292: goto L43;
            case 3701415: goto L39;
            case 109250886: goto L36;
            case 109854227: goto L33;
            case 110115790: goto L31;
            case 188995949: goto L27;
            case 953822857: goto L23;
            case 1064388554: goto L19;
            case 1144429618: goto L16;
            default: goto L134;
        };
    L33:
        r106 = "swift";
        if (r105.equals("swift") == false) goto L134;
    L136:
        if (Intrinsics.areEqual(r212, "csv") == true) goto L140;
        if (Intrinsics.areEqual(r212, CopyContentTypeString.TABLE) == true) goto L140;
    L161:
        ?? r107 = r102 + '.' + r106;
        if (TextUtils.isEmpty(r100) == false) goto L164;
    L203:
        return r103;
    L164:
        if (TextUtils.isEmpty(r107) == true) goto L203;
        if (r210 == null) goto L203;
        String r108 = FileUtils.getCacheDirPath(r210);     // Catch: Throwable -> L185 Exception -> L187
        if (TextUtils.isEmpty(r108) == true) goto L203;
        PolarisFileWrapper r109 = new PolarisFileWrapper(r108 + File.separator + "nova_export_file");     // Catch: Throwable -> L185 Exception -> L187
        if (r109.exists() == true) goto L173;
        r109.mkdirs();     // Catch: Throwable -> L185 Exception -> L187
    L173:
        PolarisFileWrapper r110 = new PolarisFileWrapper(r109, r107);     // Catch: Throwable -> L185 Exception -> L187
        if (r110.exists() == true) goto L176;
        r110.createNewFile();     // Catch: Throwable -> L185 Exception -> L187
    L176:
        byte[] r111 = r100.getBytes(StandardCharsets.UTF_8);     // Catch: Throwable -> L185 Exception -> L187
        PolarisFileOutputStreamWrapper r112 = new PolarisFileOutputStreamWrapper(r110);     // Catch: Throwable -> L185 Exception -> L187
        r112.write(r111);     // Catch: Exception -> L183 Throwable -> L195
        r112.flush();     // Catch: Exception -> L183 Throwable -> L195
        r112.close();     // Catch: Exception -> L180
        Object r113 = r112;
    L182:
        r103 = r110;
        r107 = r113;
    L204:
    L180:
        e = move-exception;
        Exception r114 = e;
        FLogger.f375446a.e("ImageFileUtils", "saveFileToCacheDir2: error ", r114);
        r113 = r114;
    L183:
        e = e;
    L189:
        FLogger.f375446a.e("ImageFileUtils", "saveFileToCacheDir1: error ", e);     // Catch: Throwable -> L195
        r107 = r112;
        if (r112 == null) goto L204;
        r112.close();     // Catch: Exception -> L193
        r107 = r112;
    L193:
        e = move-exception;
        FLogger.f375446a.e("ImageFileUtils", "saveFileToCacheDir2: error ", e);
        r107 = r112;
        goto L204
    L187:
        e = e;
        r112 = null;
    L185:
        th = th;
    L186:
        Throwable r115 = th;
        if (r104 == 0) goto L227;
        r104.close();     // Catch: Exception -> L200
        throw r115;
    L200:
        e = move-exception;
        FLogger.f375446a.e("ImageFileUtils", "saveFileToCacheDir2: error ", e);
        throw r115;
    L227:
        throw r115;
    L195:
        th = th;
        r104 = r107;
    L140:
        if (StringsKt.contains$default(r100, HiAnalyticsConstant.REPORT_VAL_SEPARATOR, false, 2, null) == false) goto L211;
        Intrinsics.checkNotNullParameter(r100, "sourceContent");
        List r116 = StringsKt.split$default(StringsKt.trim(r211).toString(), new String[]{"\n"}, false, 0, 6, null);
        StringBuilder r117 = new StringBuilder();
        Iterator r118 = r116.iterator();
    L143:
        if (r118.hasNext() == false) goto L149;
        String r119 = (String) r118.next();
        if (StringsKt.startsWith$default(r119, "|--", false, 2, null) == true) goto L143;
        if (StringsKt.startsWith$default(r119, "| --", false, 2, null) == true) goto L143;
        r117.append(CollectionsKt.joinToString$default(StringsKt.split$default(StringsKt.trim(r119, new char[]{'|'}), new String[]{HiAnalyticsConstant.REPORT_VAL_SEPARATOR}, false, 0, 6, null), ",", null, null, 0, null, new b(), 30, null));
        r117.append("\n");
        goto L143
    L149:
        r100 = r117.toString();
        goto L161
    L211:
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L156
        List r121 = StringsKt.lines(StringsKt.trim(r211).toString());     // Catch: Throwable -> L156
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));     // Catch: Throwable -> L156
        Iterator r123 = r121.iterator();     // Catch: Throwable -> L156
    L152:
        if (r123.hasNext() == false) goto L154;
        r122.add(CollectionsKt.joinToString$default(StringsKt.split$default((String) r123.next(), new String[]{"\t"}, false, 0, 6, null), ",", null, null, 0, null, new c(), 30, null));     // Catch: Throwable -> L156
        goto L152
    L154:
        r100 = CollectionsKt.joinToString$default(r122, "\n", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L156
    L156:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        Throwable r125 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r125 == null) goto L160;
        FLogger.f375446a.e("FileExportUtils", "convertToCsv error", r125);
    L160:
        r100 = "";
        goto L161
    L36:
        r106 = "scala";
        if (r105.equals("scala") == true) goto L136;
    L39:
        r106 = "yaml";
        if (r105.equals("yaml") == true) goto L136;
    L54:
        r106 = "java";
        if (r105.equals("java") == true) goto L136;
    L57:
        r106 = "html";
        if (r105.equals("html") == true) goto L136;
    L60:
        r106 = "dart";
        if (r105.equals("dart") == true) goto L136;
    L67:
        r106 = "xml";
        if (r105.equals("xml") == true) goto L136;
    L70:
        r106 = "svg";
        if (r105.equals("svg") == true) goto L136;
    L73:
        r106 = "sql";
        if (r105.equals("sql") == true) goto L136;
    L76:
        r106 = "php";
        if (r105.equals("php") == true) goto L136;
    L79:
        r106 = "lua";
        if (r105.equals("lua") == true) goto L136;
    L86:
        r106 = GXTemplateKey.GAIAX_CSS;
        if (r105.equals(GXTemplateKey.GAIAX_CSS) == true) goto L136;
    L92:
        r106 = "asm";
        if (r105.equals("asm") == true) goto L136;
    L98:
        r106 = "go";
        if (r105.equals("go") == true) goto L136;
    L101:
        r106 = "r";
        if (r105.equals("r") == true) goto L136;
    L104:
        r106 = "c";
        if (r105.equals("c") == true) goto L136;
    L111:
        r106 = "thrift";
        if (r105.equals("thrift") == true) goto L136;
    L16:
        if (r105.equals("vega-lite") == false) goto L134;
    L53:
        r106 = "json";
        goto L136
    L19:
        if (r105.equals("mindmap") == false) goto L134;
        r106 = "md";
        goto L136
    L23:
        if (r105.equals("mermaid") == false) goto L134;
        r106 = "mmd";
        goto L136
    L27:
        if (r105.equals("javascript") == false) goto L134;
        r106 = GXTemplateKey.GAIAX_JS;
        goto L136
    L31:
        if (r105.equals(CopyContentTypeString.TABLE) == false) goto L134;
    L85:
        r106 = "csv";
        goto L136
    L43:
        if (r105.equals("rust") == false) goto L134;
        r106 = "rs";
        goto L136
    L47:
        if (r105.equals("ruby") == false) goto L134;
        r106 = "rb";
        goto L136
    L51:
        if (r105.equals("json") == true) goto L53;
    L64:
        if (r105.equals("bash") == false) goto L134;
        r106 = "sh";
        goto L136
    L83:
        if (r105.equals("csv") == true) goto L85;
    L90:
        if (r105.equals("cpp") == true) goto L136;
    L96:
        if (r105.equals("c++") == true) goto L136;
    L108:
        if (r105.equals("typescript") == false) goto L134;
        r106 = "ts";
        goto L136
    L115:
        if (r105.equals("python") == false) goto L134;
        r106 = "py";
        goto L136
    L119:
        if (r105.equals("protobuf") == false) goto L134;
        r106 = "pb";
        goto L136
    L123:
        if (r105.equals("kotlin") == false) goto L134;
        r106 = "kt";
        goto L136
    L127:
        if (r105.equals("objective-c") == false) goto L134;
        r106 = "m";
        goto L136
    L131:
        if (r105.equals("csharp") == false) goto L134;
        r106 = SRStrategy.MEDIAINFO_KEY_CACHE_SIZE;
    L134:
        r106 = "txt";
        goto L136
    L9:
        r105 = null;
        goto L11
    L5:
        r102 = "code_" + r101;
        goto L6
    }
}
