package iq5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.larksuite.framework.mvp.IModel;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface m extends IModel {
    void C3(int r1);

    Flowable Y5(FragmentActivity r1);

    Flowable<DocumentListInfo> o8();
}
