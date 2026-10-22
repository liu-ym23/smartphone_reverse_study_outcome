package k9c;

import com.squareup.wire.Message;
import com.ss.android.lark.pb.ug_reach.MaterialBase;

/* JADX INFO: loaded from: classes38.dex */
public interface d<DATA extends Message<?, ?>> {
    MaterialBase a();

    String b();

    void onCreate();

    void onDestroy();

    boolean onHide();

    boolean onShow();
}
