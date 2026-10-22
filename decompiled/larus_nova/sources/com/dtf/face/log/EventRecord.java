package com.dtf.face.log;

import com.dtf.face.config.RecordBase;
import hs7.a;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes22.dex */
public class EventRecord extends RecordBase {
    private SimpleDateFormat simpleDateFormat;

    public EventRecord() {
        this.simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        setMagic("D-VM");
        setLogTime(this.simpleDateFormat.format(new Date()));
        if (a.h().S.equals("ant") == false) goto L5;
        String r100 = "8FA6890301632_ANDROID-prod";
    L6:
        setClientId(r100);
        setClientVersion("2.3.43");
        setLogVersion("2");
        setActionId("event");
        if (a.h().S.equals("ant") == false) goto L9;
        String r101 = "FinTechFaceVerify";
    L10:
        setBizType(r101);
        setLogType("c");
        setAppId("20200210");
        return;
    L9:
        r101 = "u";
        goto L10
    L5:
        r100 = "C321516081430_Android_product";
        goto L6
    }
}
