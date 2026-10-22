package f75;

import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionUploadModel;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements bu5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f75.a f475765a;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f475766a;

        public a(String r100) {
            this.f475766a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            VersionUploadModel r101 = (VersionUploadModel) JSON.parseObject(this.f475766a, new d(), new Feature[0]);
            VersionPayLoadData r102 = new VersionPayLoadData();
            r102.setToken(r101.getData().getToken());
            r102.setVersion(r101.getData().getVersion());
            r102.setSource(r101.getData().getSource());
            r102.setEditUserId(r101.getData().getEdit_user_id());
            r102.setOperation(101);
            return r102;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f75.a f475767a;

        public b(f75.a r100) {
            this.f475767a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            MutableLiveData<VersionPayLoadData> r101 = this.f475767a.f475760e;
            r101.postValue((VersionPayLoadData) r100);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f475768a = null;

        static {
            f475768a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.f("DriveComponent", (Throwable) r100, false);
        }
    }

    public e(f75.a r100) {
        this.f475765a = r100;
    }

    @Override // bu5.a
    public final void didReceivePush(String r100) {
        tt5.a.h("DriveComponent", "DRIVE_UPLOAD_FILE_VERSION: " + du5.b.f(r100));
        this.f475765a.f475759d.add(Flowable.just("").observeOn(fo5.d.a()).map(new a(r100)).observeOn(fo5.d.d()).subscribe(new b(this.f475765a), c.f475768a));
    }
}
