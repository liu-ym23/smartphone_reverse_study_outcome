package td;

import androidx.lifecycle.MutableLiveData;
import kotlin.Pair;

/* JADX INFO: loaded from: classes43.dex */
public interface e {
    MutableLiveData<Boolean> getFirstFrame();

    MutableLiveData<Boolean> getLiveEnd();

    MutableLiveData<Boolean> getPlayComplete();

    MutableLiveData<Boolean> getPlayPrepared();

    MutableLiveData<Boolean> getPlayResume();

    MutableLiveData<Boolean> getPlayerBlur();

    MutableLiveData<String> getPlayerMediaError();

    MutableLiveData<Boolean> getPlayerMute();

    MutableLiveData<Boolean> getPlaying();

    MutableLiveData<Boolean> getReleased();

    MutableLiveData<Boolean> getReset();

    MutableLiveData<String> getSeiUpdate();

    MutableLiveData<Boolean> getStopped();

    MutableLiveData<Pair<Integer, Integer>> getVideoSizeChanged();

    MutableLiveData<Boolean> isSeiCropping();
}
