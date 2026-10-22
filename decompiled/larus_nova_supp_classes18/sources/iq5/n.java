package iq5;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult;
import com.larksuite.framework.mvp.IModel;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface n extends IModel {
    Flowable<RecentOperationResult> F0();

    Flowable<DocumentListInfo> P6();
}
