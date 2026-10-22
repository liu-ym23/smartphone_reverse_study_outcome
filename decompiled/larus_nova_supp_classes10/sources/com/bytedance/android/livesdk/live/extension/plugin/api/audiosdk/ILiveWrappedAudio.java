package com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;
import mf2.c;
import mf2.d;
import mf2.e;
import mf2.f;
import mf2.g;
import mf2.h;
import mf2.i;
import va1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/audiosdk/ILiveWrappedAudio;", "Lcom/bytedance/android/live/base/IService;", "Lmf2/a;", "newSAMICore", "Lmf2/e;", "newSAMICoreAudioEncodeContextParameter", "Lmf2/b;", "newSAMICoreAsrContextCreateParameter", "Lmf2/g;", "newSAMICoreExecutorContextCreateParameter", "Lmf2/f;", "newSAMICoreBlock", "Lmf2/c;", "newSAMICoreAudioBin", "Lmf2/d;", "newSAMICoreAudioBuffer", "Lmf2/h;", "newSAMICoreProperty", "Lmf2/i;", "getSpeechEngineLoader", "Companion", "a", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveWrappedAudio extends IService {
    public static final a Companion = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static ILiveWrappedAudio a() {
            return (ILiveWrappedAudio) b.a.a.a(ILiveWrappedAudio.class);
        }
    }

    static {
        Companion = a.a;
    }

    i getSpeechEngineLoader();

    mf2.a newSAMICore();

    mf2.b newSAMICoreAsrContextCreateParameter();

    c newSAMICoreAudioBin();

    d newSAMICoreAudioBuffer();

    e newSAMICoreAudioEncodeContextParameter();

    f newSAMICoreBlock();

    g newSAMICoreExecutorContextCreateParameter();

    h newSAMICoreProperty();
}
