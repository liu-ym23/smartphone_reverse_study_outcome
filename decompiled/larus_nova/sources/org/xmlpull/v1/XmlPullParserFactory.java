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

/* JADX INFO: loaded from: classes.dex */
public class XmlPullParserFactory {
    static final Class referenceContextClass = null;
    protected String classNamesLocation;
    protected Hashtable features;
    protected Vector parserClasses;
    protected Vector serializerClasses;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static XmlPullParserFactory newInstance() throws XmlPullParserException {
        return newInstance(null, null);
    }

    static {
        new XmlPullParserFactory();
        referenceContextClass = XmlPullParserFactory.class;
    }

    public XmlPullParser newPullParser() throws XmlPullParserException {
        Vector r100 = this.parserClasses;
        if (r100 != null) goto L5;
        StringBuffer r101 = new StringBuffer("Factory initialization was incomplete - has not tried ");
        r101.append(this.classNamesLocation);
        throw new XmlPullParserException(r101.toString());
    L5:
        if (r100.size() == 0) goto L24;
        StringBuffer r102 = new StringBuffer();
        int r103 = 0;
    L8:
        if (r103 >= this.parserClasses.size()) goto L22;
        Class r104 = (Class) this.parserClasses.elementAt(r103);
        XmlPullParser r105 = (XmlPullParser) r104.newInstance();     // Catch: Exception -> L20
        Enumeration r106 = this.features.keys();     // Catch: Exception -> L20
    L12:
        if (r106.hasMoreElements() == false) goto L13;
        String r107 = (String) r106.nextElement();     // Catch: Exception -> L20
        Boolean r108 = (Boolean) this.features.get(r107);     // Catch: Exception -> L20
        if (r108 == null) goto L12;
        if (r108.booleanValue() == false) goto L12;
        r105.setFeature(r107, true);     // Catch: Exception -> L20
        goto L12
    L13:
        return r105;
    L20:
        e = move-exception;
        StringBuffer r109 = new StringBuffer();
        r109.append(r104.getName());
        r109.append(": ");
        r109.append(e.toString());
        r109.append("; ");
        r102.append(r109.toString());
        r103 = r103 + 1;
        goto L8
    L22:
        StringBuffer r110 = new StringBuffer("could not create parser: ");
        r110.append(r102);
        throw new XmlPullParserException(r110.toString());
    L24:
        StringBuffer r111 = new StringBuffer("No valid parser classes found in ");
        r111.append(this.classNamesLocation);
        throw new XmlPullParserException(r111.toString());
    }

    public XmlSerializer newSerializer() throws XmlPullParserException {
        Vector r100 = this.serializerClasses;
        if (r100 != null) goto L5;
        StringBuffer r101 = new StringBuffer("Factory initialization incomplete - has not tried ");
        r101.append(this.classNamesLocation);
        throw new XmlPullParserException(r101.toString());
    L5:
        if (r100.size() == 0) goto L16;
        StringBuffer r102 = new StringBuffer();
        int r103 = 0;
    L8:
        if (r103 >= this.serializerClasses.size()) goto L14;
        Class r104 = (Class) this.serializerClasses.elementAt(r103);
        return (XmlSerializer) r104.newInstance();
    L12:
        e = move-exception;
        StringBuffer r105 = new StringBuffer();
        r105.append(r104.getName());
        r105.append(": ");
        r105.append(e.toString());
        r105.append("; ");
        r102.append(r105.toString());
        r103 = r103 + 1;
        goto L8
    L14:
        StringBuffer r106 = new StringBuffer("could not create serializer: ");
        r106.append(r102);
        throw new XmlPullParserException(r106.toString());
    L16:
        StringBuffer r107 = new StringBuffer("No valid serializer classes found in ");
        r107.append(this.classNamesLocation);
        throw new XmlPullParserException(r107.toString());
    }

    public XmlPullParserFactory() {
        this.features = new Hashtable();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_org_xmlpull_v1_XmlPullParserFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public void setNamespaceAware(boolean r100) {
        this.features.put(XmlPullParser.FEATURE_PROCESS_NAMESPACES, new Boolean(r100));
    }

    public static XmlPullParserFactory newInstance(String r110, Class r111) throws XmlPullParserException {
        if (r111 != null) goto L5;
        r111 = referenceContextClass;
    L5:
        if (r110 != null) goto L7;
    L67:
        InputStream r112 = r111.getResourceAsStream("/META-INF/services/org.xmlpull.v1.XmlPullParserFactory");     // Catch: Exception -> L60
        if (r112 == null) goto L59;
        StringBuffer r113 = new StringBuffer();     // Catch: Exception -> L60
    L15:
        int r100 = r112.read();     // Catch: Exception -> L60
        if (r100 < 0) goto L17;
        if (r100 <= 32) goto L15;
        r113.append((char) r100);     // Catch: Exception -> L60
        goto L15
    L17:
        r112.close();     // Catch: Exception -> L60
        r110 = r113.toString();     // Catch: Exception -> L60
        StringBuffer r114 = new StringBuffer("resource /META-INF/services/org.xmlpull.v1.XmlPullParserFactory that contained '");
        r114.append(r110);
        r114.append("'");
        String r115 = r114.toString();
    L19:
        Vector r101 = new Vector();
        Vector r102 = new Vector();
        XmlPullParserFactory r103 = null;
        int r104 = 0;
    L21:
        if (r104 >= r110.length()) goto L22;
        int r105 = r110.indexOf(44, r104);
        if (r105 != (-1)) goto L29;
        r105 = r110.length();
    L29:
        String r106 = r110.substring(r104, r105);
        Class r107 = INVOKESTATIC_org_xmlpull_v1_XmlPullParserFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r106);     // Catch: Exception -> L34
        Object r108 = r107.newInstance();     // Catch: Exception -> L33
    L36:
        if (r107 == null) goto L53;
        boolean r116 = true;
        if ((r108 instanceof XmlPullParser) == false) goto L40;
        r101.addElement(r107);
        boolean r109 = true;
    L42:
        if ((r108 instanceof XmlSerializer) == false) goto L45;
        r102.addElement(r107);
        r109 = true;
    L45:
        if ((r108 instanceof XmlPullParserFactory) == false) goto L48;
        if (r103 != null) goto L49;
        r103 = (XmlPullParserFactory) r108;
    L49:
        if (r116 == true) goto L53;
        StringBuffer r117 = new StringBuffer("incompatible class: ");
        r117.append(r106);
        throw new XmlPullParserException(r117.toString());
    L48:
        r116 = r109;
        goto L49
    L40:
        r109 = false;
    L53:
        r104 = r105 + 1;
    L35:
        r108 = null;
    L34:
        r107 = null;
        goto L35
    L22:
        if (r103 != null) goto L24;
        r103 = new XmlPullParserFactory();
    L24:
        r103.parserClasses = r101;
        r103.serializerClasses = r102;
        r103.classNamesLocation = r115;
        return r103;
    L59:
        throw new XmlPullParserException("resource not found: /META-INF/services/org.xmlpull.v1.XmlPullParserFactory make sure that parser implementing XmlPull API is available");     // Catch: Exception -> L60
    L60:
        e = move-exception;
        throw new XmlPullParserException(null, null, e);
    L7:
        if (r110.length() == 0) goto L67;
        if ("DEFAULT".equals(r110) == true) goto L67;
        StringBuffer r118 = new StringBuffer("parameter classNames to newInstance() that contained '");
        r118.append(r110);
        r118.append("'");
        r115 = r118.toString();
        goto L19
    }

    public void setFeature(String r100, boolean r101) throws XmlPullParserException {
        this.features.put(r100, new Boolean(r101));
    }
}
