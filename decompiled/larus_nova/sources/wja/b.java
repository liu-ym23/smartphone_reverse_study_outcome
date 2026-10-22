package wja;

import android.util.Xml;
import com.bytedance.keva.KevaImpl;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f560057a = 0;

    static {
    }

    public static void a(PolarisFileInputStreamWrapper r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r110, "inputStream");
        Intrinsics.checkNotNullParameter(r111, "onFileFound");
        XmlPullParser r100 = Xml.newPullParser();
        r100.setInput(r110, "UTF-8");
        int r112 = r100.getEventType();
    L4:
        if (r112 == 1) goto L35;
        if (r112 != 2) goto L34;
        if (Intrinsics.areEqual(r100.getName(), "file") == false) goto L34;
        String r101 = r100.getAttributeValue(null, "base");
        if (r101 != null) goto L12;
        String r102 = "";
    L13:
        String r103 = r100.getAttributeValue(null, "path");
        if (r103 != null) goto L16;
        String r104 = "";
    L17:
        String r105 = r100.getAttributeValue(null, LynxEventReporter.PROP_NAME_RELATIVE_PATH);
        if (r105 != null) goto L20;
        String r106 = r104;
    L21:
        String r107 = r100.getAttributeValue(null, "size");
        if (r107 == null) goto L26;
        Long r108 = StringsKt.toLongOrNull(r107);
        if (r108 == null) goto L26;
        long r109 = r108.longValue();
    L27:
        long r113 = r109;
        String r114 = r100.getAttributeValue(null, "retry_times");
        if (r114 == null) goto L32;
        Integer r115 = StringsKt.toIntOrNull(r114);
        if (r115 == null) goto L32;
        int r116 = r115.intValue();
    L33:
        r111.invoke(new a(r102, r104, r113, r116, r106));
    L32:
        r116 = 5;
    L26:
        r109 = 0;
        goto L27
    L20:
        r106 = r105;
        goto L21
    L16:
        r104 = r103;
        goto L17
    L12:
        r102 = r101;
    L34:
        r112 = r100.next();
        goto L4
    }

    public static void b(Sequence r100, PolarisFileOutputStreamWrapper r101) {
        Intrinsics.checkNotNullParameter(r100, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        Intrinsics.checkNotNullParameter(r101, "outputStream");
        XmlSerializer r102 = Xml.newSerializer();
        r102.setOutput(r101, "UTF-8");
        r102.startDocument("UTF-8", Boolean.TRUE);
        r102.startTag(null, "list");
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        a r104 = (a) r103.next();
        r102.startTag(null, "file");
        r102.attribute(null, "base", r104.f560052a);
        r102.attribute(null, "path", r104.f560053b);
        r102.attribute(null, LynxEventReporter.PROP_NAME_RELATIVE_PATH, r104.f560056e);
        r102.attribute(null, "size", String.valueOf(r104.f560054c));
        r102.attribute(null, "retry_times", String.valueOf(r104.f560055d));
        r102.endTag(null, "file");
        r102.flush();
        goto L4
    L6:
        r102.endTag(null, "list");
        r102.endDocument();
        r102.flush();
    }
}
