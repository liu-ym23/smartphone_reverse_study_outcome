package mi5;

import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: classes18.dex */
public interface g {
    boolean getLeaderShareSetting(IGetDataCallback<Boolean> r100);

    void shutDown();

    void updateLeaderShareSetting(boolean r100, IGetDataCallback<Boolean> r101);
}
