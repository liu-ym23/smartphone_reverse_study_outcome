package v99;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.DoubaoFileInfo;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;

/* JADX INFO: loaded from: classes29.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f553877a = 0;

    static {
    }

    public static void a(String r100, UplinkFileEntity r101) {
        DoubaoFileInfo r102 = r101.getDoubaoFileInfo();
        Integer r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getResourceUri();
    L6:
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("[");
        r106.append(r100);
        r106.append("] identifier=");
        r106.append(r101.getFileIdentifier());
        r106.append(", infoPresent=");
        if (r102 == null) goto L9;
        boolean r107 = true;
    L10:
        r106.append(r107);
        r106.append(", resourceUriLength=");
        if (r104 == null) goto L13;
        Integer r108 = Integer.valueOf(r104.length());
    L14:
        r106.append(r108);
        r106.append(", resourceUriHash=");
        if (r104 == null) goto L17;
        Integer r109 = Integer.valueOf(r104.hashCode());
    L18:
        r106.append(r109);
        r106.append(", storageType=");
        if (r102 == null) goto L21;
        r103 = r102.getStorageType();
    L21:
        r106.append(r103);
        r105.i("OfficeSdkDoubaoFileInfo", r106.toString());
        return;
    L17:
        r109 = null;
        goto L18
    L13:
        r108 = null;
        goto L14
    L9:
        r107 = false;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
