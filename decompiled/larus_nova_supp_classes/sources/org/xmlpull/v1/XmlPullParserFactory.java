package org.xmlpull.v1;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class XmlPullParserFactory {
    static final Class referenceContextClass = null;
    protected String classNamesLocation;
    protected Hashtable features;
    protected Vector parserClasses;
    protected Vector serializerClasses;

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static XmlPullParserFactory newInstance() throws XmlPullParserException {
        return newInstance(null, null);
    }

    static {
        new XmlPullParserFactory();
        referenceContextClass = XmlPullParserFactory.class;
    }

    public XmlPullParser newPullParser() throws XmlPullParserException {
        Vector r0 = this.parserClasses;
        if (r0 != null) goto L5;
        StringBuffer r1 = new StringBuffer("Factory initialization was incomplete - has not tried ");
        r1.append(this.classNamesLocation);
        throw new XmlPullParserException(r1.toString());
    L5:
        if (r0.size() == 0) goto L24;
        StringBuffer r2 = new StringBuffer();
        int r3 = 0;
    L8:
        if (r3 >= this.parserClasses.size()) goto L22;
        Class r4 = (Class) this.parserClasses.elementAt(r3);
        XmlPullParser r5 = (XmlPullParser) r4.newInstance();     // Catch: Exception -> L20
        Enumeration r6 = this.features.keys();     // Catch: Exception -> L20
    L12:
        if (r6.hasMoreElements() == false) goto L13;
        String r7 = (String) r6.nextElement();     // Catch: Exception -> L20
        Boolean r8 = (Boolean) this.features.get(r7);     // Catch: Exception -> L20
        if (r8 == null) goto L12;
        if (r8.booleanValue() == false) goto L12;
        r5.setFeature(r7, true);     // Catch: Exception -> L20
        goto L12
    L13:
        return r5;
    L20:
        e = move-exception;
        StringBuffer r9 = new StringBuffer();
        r9.append(r4.getName());
        r9.append(": ");
        r9.append(e.toString());
        r9.append("; ");
        r2.append(r9.toString());
        r3 = r3 + 1;
        goto L8
    L22:
        StringBuffer r10 = new StringBuffer("could not create parser: ");
        r10.append(r2);
        throw new XmlPullParserException(r10.toString());
    L24:
        StringBuffer r11 = new StringBuffer("No valid parser classes found in ");
        r11.append(this.classNamesLocation);
        throw new XmlPullParserException(r11.toString());
    }

    public XmlSerializer newSerializer() throws XmlPullParserException {
        Vector r0 = this.serializerClasses;
        if (r0 != null) goto L5;
        StringBuffer r1 = new StringBuffer("Factory initialization incomplete - has not tried ");
        r1.append(this.classNamesLocation);
        throw new XmlPullParserException(r1.toString());
    L5:
        if (r0.size() == 0) goto L16;
        StringBuffer r2 = new StringBuffer();
        int r3 = 0;
    L8:
        if (r3 >= this.serializerClasses.size()) goto L14;
        Class r4 = (Class) this.serializerClasses.elementAt(r3);
        return (XmlSerializer) r4.newInstance();
    L12:
        e = move-exception;
        StringBuffer r5 = new StringBuffer();
        r5.append(r4.getName());
        r5.append(": ");
        r5.append(e.toString());
        r5.append("; ");
        r2.append(r5.toString());
        r3 = r3 + 1;
        goto L8
    L14:
        StringBuffer r6 = new StringBuffer("could not create serializer: ");
        r6.append(r2);
        throw new XmlPullParserException(r6.toString());
    L16:
        StringBuffer r7 = new StringBuffer("No valid serializer classes found in ");
        r7.append(this.classNamesLocation);
        throw new XmlPullParserException(r7.toString());
    }

    public XmlPullParserFactory() {
        this.features = new Hashtable();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_org_xmlpull_v1_XmlPullParserFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public void setNamespaceAware(boolean r3) {
        this.features.put(XmlPullParser.FEATURE_PROCESS_NAMESPACES, new Boolean(r3));
    }

    public static XmlPullParserFactory newInstance(String r12, Class r13) throws XmlPullParserException {
        if (r13 != null) goto L5;
        r13 = referenceContextClass;
    L5:
        if (r12 != null) goto L7;
    L67:
        InputStream r14 = r13.getResourceAsStream("/META-INF/services/org.xmlpull.v1.XmlPullParserFactory");     // Catch: Exception -> L60
        if (r14 == null) goto L59;
        StringBuffer r15 = new StringBuffer();     // Catch: Exception -> L60
    L15:
        int r2 = r14.read();     // Catch: Exception -> L60
        if (r2 < 0) goto L17;
        if (r2 <= 32) goto L15;
        r15.append((char) r2);     // Catch: Exception -> L60
        goto L15
    L17:
        r14.close();     // Catch: Exception -> L60
        r12 = r15.toString();     // Catch: Exception -> L60
        StringBuffer r16 = new StringBuffer("resource /META-INF/services/org.xmlpull.v1.XmlPullParserFactory that contained '");
        r16.append(r12);
        r16.append("'");
        String r17 = r16.toString();
    L19:
        Vector r0 = new Vector();
        Vector r3 = new Vector();
        XmlPullParserFactory r5 = null;
        int r4 = 0;
    L21:
        if (r4 >= r12.length()) goto L22;
        int r6 = r12.indexOf(44, r4);
        if (r6 != (-1)) goto L29;
        r6 = r12.length();
    L29:
        String r7 = r12.substring(r4, r6);
        Class r8 = INVOKESTATIC_org_xmlpull_v1_XmlPullParserFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r7);     // Catch: Exception -> L34
        Object r9 = r8.newInstance();     // Catch: Exception -> L33
    L36:
        if (r8 == null) goto L53;
        boolean r10 = true;
        if ((r9 instanceof XmlPullParser) == false) goto L40;
        r0.addElement(r8);
        boolean r11 = true;
    L42:
        if ((r9 instanceof XmlSerializer) == false) goto L45;
        r3.addElement(r8);
        r11 = true;
    L45:
        if ((r9 instanceof XmlPullParserFactory) == false) goto L48;
        if (r5 != null) goto L49;
        r5 = (XmlPullParserFactory) r9;
    L49:
        if (r10 == true) goto L53;
        StringBuffer r18 = new StringBuffer("incompatible class: ");
        r18.append(r7);
        throw new XmlPullParserException(r18.toString());
    L48:
        r10 = r11;
        goto L49
    L40:
        r11 = false;
    L53:
        r4 = r6 + 1;
    L35:
        r9 = null;
    L34:
        r8 = null;
        goto L35
    L22:
        if (r5 != null) goto L24;
        r5 = new XmlPullParserFactory();
    L24:
        r5.parserClasses = r0;
        r5.serializerClasses = r3;
        r5.classNamesLocation = r17;
        return r5;
    L59:
        throw new XmlPullParserException("resource not found: /META-INF/services/org.xmlpull.v1.XmlPullParserFactory make sure that parser implementing XmlPull API is available");     // Catch: Exception -> L60
    L60:
        e = move-exception;
        throw new XmlPullParserException(null, null, e);
    L7:
        if (r12.length() == 0) goto L67;
        if ("DEFAULT".equals(r12) == true) goto L67;
        StringBuffer r19 = new StringBuffer("parameter classNames to newInstance() that contained '");
        r19.append(r12);
        r19.append("'");
        r17 = r19.toString();
        goto L19
    }

    public void setFeature(String r3, boolean r4) throws XmlPullParserException {
        this.features.put(r3, new Boolean(r4));
    }
}
