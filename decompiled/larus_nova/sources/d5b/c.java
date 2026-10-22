package d5b;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.basic.v1.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;

/* JADX INFO: loaded from: classes35.dex */
public interface c {

    public interface a {
        void a();

        void onDestroy();

        void onStart();

        void onStop();
    }

    PartialReplyInfo c();

    String d();

    Message.PartialReplyInfo f();

    Activity getActivity();

    String h();

    void i();

    void k(xb5.c r100);

    Fragment l();

    void m();
}
