package k2;

import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public interface q extends h, o, r, com.bytedance.assem.arch.service.c {
    void b(Map<String, ? extends Object> r100);

    void doRefresh();

    boolean goBack();

    void onBackPress();

    void setTitle(String r100);

    String url();
}
