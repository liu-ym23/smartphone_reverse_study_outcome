package i55;

import com.bytedance.ee.drive.mime.DriveLocalMime;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements pw4.f {
    public g() {
    }

    @Override // pw4.f
    public final int a() {
        int r100 = DriveLocalMime.IMAGE.getValue();
        return g85.g.f480401b.get(r100, R.string.Drive_Drive_DefaultFileType);
    }

    @Override // pw4.f
    public final int getImportType(String r100) {
        return f.a(r100);
    }
}
