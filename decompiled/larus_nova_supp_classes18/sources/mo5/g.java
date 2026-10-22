package mo5;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.impl.TtsAlbumViewModel$reloadAlbum$2;
import com.bytedance.ee.bear.tts.impl.o;
import com.bytedance.ee.bear.tts.tone.TtsToneBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface g {
    String a();

    MutableLiveData b();

    MutableLiveData c();

    void d(String r1, o r2);

    void e();

    void f(TtsToneBean r1, po5.b.a r2);

    MutableLiveData g();

    void h(TtsLoadScene r1, b r2);

    MutableLiveData i();

    MutableLiveData j();

    void k(float r1, po5.d.a r2);

    TtsResult l(String r1);

    to5.a m();

    MutableLiveData n();

    MutableLiveData o();

    void onDestroy();

    void p(TtsLoadScene r1, b r2);

    void pause();

    void q();

    MutableLiveData r();

    void s(TtsLoadScene r1, TtsAlbumViewModel$reloadAlbum$2.a r2);

    void t(long r1, b r3);

    MutableLiveData u();

    MutableLiveData v();

    void w(TtsLoadScene r1, po5.b.a.C0292a r2);
}
