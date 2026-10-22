package mo5;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.impl.TtsAlbumViewModel$reloadAlbum$2;
import com.bytedance.ee.bear.tts.impl.o;
import com.bytedance.ee.bear.tts.tone.TtsToneBean;

/* JADX INFO: loaded from: classes18.dex */
public interface g {
    String a();

    MutableLiveData b();

    MutableLiveData c();

    void d(String r100, o r101);

    void e();

    void f(TtsToneBean r100, po5.b.a r101);

    MutableLiveData g();

    void h(TtsLoadScene r100, b r101);

    MutableLiveData i();

    MutableLiveData j();

    void k(float r100, po5.d.a r101);

    TtsResult l(String r100);

    to5.a m();

    MutableLiveData n();

    MutableLiveData o();

    void onDestroy();

    void p(TtsLoadScene r100, b r101);

    void pause();

    void q();

    MutableLiveData r();

    void s(TtsLoadScene r100, TtsAlbumViewModel$reloadAlbum$2.a r101);

    void t(long r100, b r101);

    MutableLiveData u();

    MutableLiveData v();

    void w(TtsLoadScene r100, po5.b.a.C7219a r101);
}
