package pt;

import bw.p;
import com.bytedance.android.gamecp.base.network.response.i;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;
import io.reactivex.functions.Consumer;
import wu.l4;

/* JADX INFO: loaded from: classes44.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f530622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String[] f530623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BDImageXUploaderListener f530624c;

    public d(int r100, String[] r101, com.bytedance.android.gamecp.business.comment.edit.upload.a r102) {
        this.f530622a = r100;
        this.f530623b = r101;
        this.f530624c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        i r101 = (i) r100;
        if (r101 == null) goto L20;
        BDImageXUploader r102 = new BDImageXUploader();
        r102.setUploadDomain(l4.f561346a.getValue().a());
        r102.setTopAccessKey(((qt.a) r101.data).accessKeyId);
        r102.setTopSecretKey(((qt.a) r101.data).secretAccessKey);
        r102.setTopSessionToken(((qt.a) r101.data).sessionToken);
        r102.setServiceID(((qt.a) r101.data).serviceId);
        r102.setTraceId("live_cooperation_partner_evaluation");
        bw.d r103 = com.bytedance.android.gamecp.host_api.a.b().getHostContext();
        String r104 = null;
        if (r103 == null) goto L7;
        Integer r105 = Integer.valueOf(r103.hostAppId());
    L8:
        int r106 = r105.intValue();
        if (r103 == null) goto L11;
        r104 = r103.M();
    L11:
        p r107 = com.bytedance.android.gamecp.host_api.a.b().getUserService();
        if (r107 == null) goto L17;
        hw.b r108 = r107.user();
        if (r108 == null) goto L17;
        String r109 = r108.getCurrentUserId();
        if (r109 == null) goto L17;
    L18:
        r102.setServerParameter("appid=" + r106 + "&did=" + r104 + "&uid=" + r109 + "&Region=cn&StoreRegion=cn");
        r102.setObjectType("image");
        r102.setRWTimeout(40);
        r102.setMaxFailTime(70);
        r102.setTranTimeOutUnit(8);
        r102.setFileRetryCount(1);
        r102.setEnableHttps(1);
        r102.setFilePath(this.f530622a, this.f530623b);
        r102.setListener(new c(r102, this));
        r102.start();
        return;
    L17:
        r109 = "";
        goto L18
    L7:
        r105 = null;
        goto L8
    }
}
