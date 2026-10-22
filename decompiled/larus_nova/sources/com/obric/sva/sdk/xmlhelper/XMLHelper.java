package com.obric.sva.sdk.xmlhelper;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes34.dex */
public class XMLHelper {
    private static final String TAG = null;
    private static final String TAG_CONTAINER = "Container";
    private static final String TAG_CONTAINERGROUP = "ContainerGroup";
    private static final String TAG_ITEM = "Item";
    private static final String TAG_NAME = "name";
    private static final String TAG_TYPE = "type";
    private static final String TAG_VALUE = "value";
    private String mSMLConfigPath;

    public ContainerGroup read() {
        ContainerGroup r100 = null;
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(this.mSMLConfigPath));     // Catch: IOException -> L40 Throwable -> L42
        XmlPullParser r102 = XmlPullParserFactory.newInstance().newPullParser();     // Catch: Throwable -> L34
        r102.setInput(r101, "UTF-8");     // Catch: Throwable -> L34
        Item r103 = null;
        int r104 = r102.getEventType();     // Catch: Throwable -> L34
        Container r105 = null;
    L7:
        if (r104 == 1) goto L32;
        if (r104 == 2) goto L22;
        if (r104 != 3) goto L30;
        if (TAG_ITEM.equals(r102.getName()) == false) goto L18;
        if (r105 == null) goto L30;
        r105.put(r103);     // Catch: Throwable -> L34
        goto L30
    L18:
        if ("Container".equals(r102.getName()) == false) goto L30;
        if (r100 == null) goto L30;
        r100.addContainer(r105);     // Catch: Throwable -> L34
    L30:
        r104 = r102.next();     // Catch: Throwable -> L34
        goto L7
    L22:
        if (TAG_CONTAINERGROUP.equals(r102.getName()) == false) goto L25;
        r100 = createContainerGroup(r102);     // Catch: Throwable -> L34
        goto L30
    L25:
        if ("Container".equals(r102.getName()) == false) goto L28;
        r105 = createContainer(r102);     // Catch: Throwable -> L34
        goto L30
    L28:
        if (TAG_ITEM.equals(r102.getName()) == false) goto L30;
        r103 = createItem(r102);     // Catch: Throwable -> L34
        goto L30
    L32:
        r101.close();     // Catch: IOException -> L40 Throwable -> L42
    L44:
        return r100;
    L34:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L37
    L39:
        throw th;     // Catch: IOException -> L40 Throwable -> L42
    L37:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L40 Throwable -> L42
    L42:
        e = move-exception;
        e.getCause();
        goto L44
    }

    static {
        TAG = "XMLHelper";
    }

    public XMLHelper(String r100) {
        this.mSMLConfigPath = r100;
    }

    private Container createContainer(XmlPullParser r100) {
        Container r101 = new Container();
        r101.setName(r100.getAttributeValue(null, "name"));
        return r101;
    }

    private ContainerGroup createContainerGroup(XmlPullParser r100) {
        return new ContainerGroup();
    }

    private Item createItem(XmlPullParser r100) {
        return new Item(r100.getAttributeValue(null, "name"), r100.getAttributeValue(null, "value"), r100.getAttributeValue(null, "type"));
    }
}
