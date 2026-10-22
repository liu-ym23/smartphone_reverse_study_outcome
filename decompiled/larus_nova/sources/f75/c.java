package f75;

import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionDeleteModel;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements bu5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f75.a f475761a;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f475762a;

        public a(String r100) {
            this.f475762a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            VersionDeleteModel r101 = (VersionDeleteModel) JSON.parseObject(this.f475762a, new f75.b(), new Feature[0]);
            VersionPayLoadData r102 = new VersionPayLoadData();
            r102.setToken(r101.getData().getToken());
            r102.setVersion(r101.getData().getVersion());
            r102.setSource(r101.getData().getSource());
            r102.setEditUserId(r101.getData().getEdit_user_id());
            r102.setOperation(102);
            return r102;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f75.a f475763a;

        public b(f75.a r100) {
            this.f475763a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            MutableLiveData<VersionPayLoadData> r101 = this.f475763a.f475760e;
            r101.postValue((VersionPayLoadData) r100);
        }
    }

    /* JADX INFO: renamed from: f75.c$c, reason: collision with other inner class name */
    public static final class C5865c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5865c<T> f475764a = null;

        static {
            f475764a = new C5865c();
        }

        public C5865c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.f("DriveComponent", (Throwable) r100, false);
        }
    }

    public c(f75.a r100) {
        this.f475761a = r100;
    }

    @Override // bu5.a
    public final void didReceivePush(String r100) {
        tt5.a.h("DriveComponent", "DRIVE_DELETE_FILE_VERSION: " + r100);
        this.f475761a.f475759d.add(Flowable.just("").observeOn(fo5.d.a()).map(new a(r100)).observeOn(fo5.d.d()).subscribe(new b(this.f475761a), C5865c.f475764a));
    }
}
