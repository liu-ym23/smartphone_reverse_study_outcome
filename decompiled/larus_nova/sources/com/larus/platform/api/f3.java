package com.larus.platform.api;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common_ui.view.GradientMaskView;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface f3 {

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ int a() {
            return com.larus.platform.service.e2.f365734a.d(null);
        }

        public static /* synthetic */ int b() {
            return com.larus.platform.service.e2.f365734a.e(null);
        }
    }

    boolean a(Activity r100, Configuration r101);

    void b(ChatConstraintLayout r100, List r101);

    void c(LinearLayoutManager r100, GradientMaskView r101, boolean r102);

    int d(Integer r100);

    int e(ViewGroup r100);

    int f();

    int g();

    boolean isPad();
}
