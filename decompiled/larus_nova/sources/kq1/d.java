package kq1;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.replay.paid.ReplayUpdatePaidData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Unit;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Boolean> f505580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NextLiveData<Boolean> f505581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Boolean> f505582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Boolean> f505583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<Boolean> f505584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<ReplayUpdatePaidData> f505585f;

    public d() {
        MutableLiveData<Boolean> r100 = new MutableLiveData();
        Boolean r101 = Boolean.FALSE;
        r100.setValue(r101);
        Unit r102 = Unit.INSTANCE;
        this.f505580a = r100;
        NextLiveData<Boolean> r103 = new NextLiveData();
        r103.setValue(r101);
        this.f505581b = r103;
        MutableLiveData<Boolean> r104 = new MutableLiveData();
        r104.setValue(r101);
        this.f505582c = r104;
        MutableLiveData<Boolean> r105 = new MutableLiveData();
        r105.setValue(r101);
        this.f505583d = r105;
        MutableLiveData<Boolean> r106 = new MutableLiveData();
        r106.setValue(Boolean.TRUE);
        this.f505584e = r106;
        MutableLiveData<ReplayUpdatePaidData> r107 = new MutableLiveData();
        r107.setValue(null);
        this.f505585f = r107;
    }
}
