package on4;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.basesdk.AbsLocaleServiceImp;
import java.util.Locale;

/* JADX INFO: loaded from: classes15.dex */
public final class x extends AbsLocaleServiceImp {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f524349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f524350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<String> f524351d;

    @Override // com.bytedance.ee.bear.contract.i0
    public final String a() {
        w r100 = this.f524350c;
        if (r100 != null) goto L5;
        tt5.a.e("SdkLocaleServiceWrapper", "mLocalProvider == null", new Throwable(), false);
        Locale r101 = Locale.ENGLISH;
    L7:
        return r101.getLanguage();
    L5:
        r101 = r100.getLocale();
        goto L7
    }

    @Override // com.bytedance.ee.bear.contract.i0
    public final Locale c() {
        w r100 = this.f524350c;
        if (r100 != null) goto L5;
        tt5.a.e("SdkLocaleServiceWrapper", "mLocalProvider == null", new Throwable(), false);
        Locale r101 = Locale.ENGLISH;
    L6:
        String r102 = r101.getLanguage();
        if (TextUtils.equals(this.f524349b, r102) == true) goto L9;
        this.f524349b = r102;
        this.f524351d.postValue(r102);
    L9:
        return r101;
    L5:
        r101 = r100.getLocale();
        goto L6
    }

    public final void finalize() throws Throwable {
        AbsLocaleServiceImp.c.unregisterReceiver(this.f206458a);
        AbsLocaleServiceImp.a.unregisterReceiver(this.f206458a);
        super.finalize();
    }

    public x() {
        this.f524351d = new MutableLiveData();
        this.f524350c = (w) org.koin.java.a.a(w.class);
        Context r100 = eu5.b.f474075a.getApplicationContext();
        this.f206458a = r100;
        AbsLocaleServiceImp.c.registerReceiver(r100);
        AbsLocaleServiceImp.a.registerReceiver(this.f206458a);
    }

    @Override // com.bytedance.ee.bear.contract.i0
    public final MutableLiveData b() {
        return this.f524351d;
    }
}
