package com.bytedance.lynx.media.playable;

import android.widget.FrameLayout;
import com.bytedance.lynx.media.AbsMediaEngineView;
import com.bytedance.lynx.media.b;
import com.ss.ttvideoengine.DataSource;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import j07.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes21.dex */
public interface IVideoEnginePlayable {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/lynx/media/playable/IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType;", "", "TYPE_STRING", "TYPE_INT", "TYPE_LONG", "TYPE_FLOAT", "x-element-media_release"}, k = 1, mv = {1, 6, 0})
    public static final enum IVideoEnginePlayablePlayOptionType extends Enum<IVideoEnginePlayablePlayOptionType> {
        public static final IVideoEnginePlayablePlayOptionType TYPE_FLOAT = null;
        public static final IVideoEnginePlayablePlayOptionType TYPE_INT = null;
        public static final IVideoEnginePlayablePlayOptionType TYPE_LONG = null;
        public static final IVideoEnginePlayablePlayOptionType TYPE_STRING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IVideoEnginePlayablePlayOptionType[] f264835a = null;

        public static IVideoEnginePlayablePlayOptionType valueOf(String r100) {
            return (IVideoEnginePlayablePlayOptionType) r27.a.a(IVideoEnginePlayablePlayOptionType.class, r100);
        }

        public static IVideoEnginePlayablePlayOptionType[] values() {
            return (IVideoEnginePlayablePlayOptionType[]) f264835a.clone();
        }

        static {
            IVideoEnginePlayablePlayOptionType r100 = new IVideoEnginePlayablePlayOptionType("TYPE_STRING", 0);
            TYPE_STRING = r100;
            IVideoEnginePlayablePlayOptionType r101 = new IVideoEnginePlayablePlayOptionType("TYPE_INT", 1);
            TYPE_INT = r101;
            IVideoEnginePlayablePlayOptionType r102 = new IVideoEnginePlayablePlayOptionType("TYPE_LONG", 2);
            TYPE_LONG = r102;
            IVideoEnginePlayablePlayOptionType r103 = new IVideoEnginePlayablePlayOptionType("TYPE_FLOAT", 3);
            TYPE_FLOAT = r103;
            f264835a = new IVideoEnginePlayablePlayOptionType[]{r100, r101, r102, r103};
        }

        public IVideoEnginePlayablePlayOptionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a(int r100, c r101, int r102, String r103);
    }

    void a(b r100);

    void b(long r100, boolean r101, b r102);

    void c(b r100);

    void destroy();

    void e(i07.a r100);

    void f(b r100);

    void g(a r100);

    void h(Map<Integer, ? extends Pair<? extends Object, ? extends IVideoEnginePlayablePlayOptionType>> r100);

    void i(b r100);

    void initialize();

    int j(AbsMediaEngineView.a r100);

    void k(b r100);

    void l(FrameLayout r100);

    void m(b r100);

    void o(Map<String, ? extends Object> r100);

    void setDataSource(DataSource r100);

    void setVideoEngineCallback(VideoEngineCallback r100);

    void setVideoEngineInfoListener(VideoEngineInfoListener r100);
}
