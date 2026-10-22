package k2;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;

/* JADX INFO: loaded from: classes43.dex */
public interface j extends i, p, k {
    void doRefresh();

    AppletRuntime getAppletRuntime();

    t getFloatingSpeakerController();

    PageInfo getPageInfo();

    void handleContentSizeChange(double r100, double r101);

    void setFloatingSpeakerController(t r100);

    void setUiContext(String r100);

    String viewContext();
}
