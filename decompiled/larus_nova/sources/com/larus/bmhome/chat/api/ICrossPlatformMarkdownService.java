package com.larus.bmhome.chat.api;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larus.list.arch.IFlowListCell;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\b\u0010\b\u001a\u00020\tH&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H&J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/api/ICrossPlatformMarkdownService;", "", "isWidgetCell", "", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "getAllVisibleWidget", "", "Landroid/view/View;", "clearAllVisibleWidget", "", "provideCustomDataHandler", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "findVisibleWidget", "viewGroup", "Landroid/view/ViewGroup;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICrossPlatformMarkdownService {
    void a(ViewGroup r100);

    List<View> b();

    void c();

    boolean d(IFlowListCell r100);
}
