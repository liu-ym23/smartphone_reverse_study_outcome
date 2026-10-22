package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes41.dex */
public class ev {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private XmlPullParser f463507a;

    public ev() {
        XmlPullParser r100 = XmlPullParserFactory.newInstance().newPullParser();     // Catch: XmlPullParserException -> L5
        this.f463507a = r100;     // Catch: XmlPullParserException -> L5
        r100.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);     // Catch: XmlPullParserException -> L5
        return;
    }

    public fn a(byte[] r100, ez r101) {
        this.f463507a.setInput(new InputStreamReader(new ByteArrayInputStream(r100)));
        this.f463507a.next();
        int r102 = this.f463507a.getEventType();
        String r103 = this.f463507a.getName();
        if (r102 == 2) goto L5;
        return null;
    L5:
        if (r103.equals("message") == false) goto L9;
        return fv.a(this.f463507a);
    L9:
        if (r103.equals("iq") == false) goto L13;
        return fv.a(this.f463507a, r101);
    L13:
        if (r103.equals("presence") == false) goto L17;
        return fv.m9108a(this.f463507a);
    L17:
        if (this.f463507a.getName().equals("stream") == false) goto L20;
        return null;
    L20:
        if (this.f463507a.getName().equals("error") == true) goto L26;
        if (this.f463507a.getName().equals("warning") == false) goto L24;
        this.f463507a.next();
        this.f463507a.getName().equals("multi-login");
        return null;
    L24:
        this.f463507a.getName().equals("bind");
        return null;
    L26:
        throw new fh(fv.m9109a(this.f463507a));
    }
}
