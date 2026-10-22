package mlb;

import android.app.Activity;
import android.graphics.Bitmap;
import com.ss.android.lark.imageqrcode.QRCodeResultInfo;
import dxa.g;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes36.dex */
public interface a {
    g decodeQRCode(String r100);

    ArrayList<QRCodeResultInfo> decodeQRCode(Bitmap r100);

    void openResultPage(Activity r100, String r101);
}
