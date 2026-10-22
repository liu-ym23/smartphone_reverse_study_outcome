package pd;

import android.view.View;
import java.util.Set;

/* JADX INFO: loaded from: classes43.dex */
public interface c {
    void onAttachView(View r100, String r101);

    void onBeforeCreateRenderData(View r100);

    void onBeforeGlobalPropsInitialize();

    void onBeforeInitialPropsInitialize();

    void onBeforeJsbRegister();

    void onBeforeLynxEnvInitialize(boolean r100);

    void onBeforeOpenContainer();

    void onContainerError(View r100, int r101, String r102);

    void onContainerInitEnd();

    void onContainerInitStart();

    void onCreateRenderData(View r100, Set<String> r101);

    boolean onFallback(int r100, String r101);

    void onGlobalPropsInitialized();

    void onInitialPropsInitialized();

    void onInnerFallback(int r100, String r101);

    void onJsbRegistered();

    void onLoadFail(View r100, String r101, String r102);

    void onLoadStart(View r100, boolean r101);

    void onLoadSuccess(View r100);

    void onLynxEnvInitialized();

    void onPrepareComponentEnd();

    void onPrepareComponentStart();

    void onPrepareInitDataEnd();

    void onPrepareInitDataStart(String r100, String r101, boolean r102);

    void onPrepareTemplateEnd();

    void onPrepareTemplateStart();

    void onRelease();
}
