package gi7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.applog.h;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f481466a;

    @Override // com.bytedance.applog.h
    public final void a(boolean r100, JSONObject r101) {
    }

    public e(Uri r100) {
        this.f481466a = r100;
    }

    @Override // com.bytedance.applog.h
    public final void onIdLoaded(String r100, String r101, String r102) {
        mi7.e.a("SchemaFirstLaunchReporter", "onIdLoaded " + r100 + '.');
        if (TextUtils.isEmpty(r100) == true) goto L6;
        AtomicBoolean r103 = g.f481468a;
        g.a(this.f481466a, r100);
        return;
    }

    @Override // com.bytedance.applog.h
    public final void onRemoteIdGet(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        mi7.e.a("SchemaFirstLaunchReporter", "onRemoteIdGet " + r102 + '.');
        if (TextUtils.isEmpty(r102) == true) goto L6;
        AtomicBoolean r107 = g.f481468a;
        g.a(this.f481466a, r102);
        return;
    }
}
