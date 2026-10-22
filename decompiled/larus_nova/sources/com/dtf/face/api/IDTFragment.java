package com.dtf.face.api;

import android.widget.FrameLayout;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public interface IDTFragment extends IDTFragmentCallBack {

    public interface ICloseCallBack {
        void onBack();

        void onClose();
    }

    public interface IDTCallBack {
        void onElderAudioSwitch(boolean r100);

        void onFaceRegionChange(Map<String, Object> r100);
    }

    FrameLayout getCameraContainer();

    FrameLayout getPhotinusContainer();

    boolean isActive();

    void onUILoadSuccess();

    void setCloseCallBack(ICloseCallBack r100);

    void setDTCallBack(IDTCallBack r100);
}
