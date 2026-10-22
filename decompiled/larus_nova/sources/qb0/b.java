package qb0;

import com.bytedance.android.live.ktv.common.midi.g;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import kotlin.Pair;

/* JADX INFO: loaded from: classes45.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ Pair a(b r100, float r101, float r102, float r103, boolean r110, boolean r111, int r112) {
            if ((r112 & 4) == 0) goto L5;
            float r104 = 0.0f;
        L7:
            if ((r112 & 8) == 0) goto L9;
            boolean r105 = false;
        L11:
            if ((r112 & 16) == 0) goto L13;
            boolean r106 = false;
        L15:
            return r100.l1(r101, r102, r104, r105, r106);
        L13:
            r106 = r111;
            goto L15
        L9:
            r105 = r110;
            goto L11
        L5:
            r104 = r103;
            goto L7
        }
    }

    void D3(long r100);

    void D5(int r100, int r101);

    void J3(long r100);

    void S3();

    void clear();

    void detach();

    void f0(db0.a r100, g r101);

    void hide();

    Pair<Float, Float> l1(float r100, float r101, float r102, boolean r103, boolean r104);

    void setScoreInterval(long r100);

    void show();

    void y(MidiSkinDressInfo r100);
}
