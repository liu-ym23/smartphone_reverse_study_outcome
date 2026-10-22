package da5;

import androidx.lifecycle.LiveData;

/* JADX INFO: loaded from: classes16.dex */
public interface d<Content> {
    void changeCollapseStatus(String r100, boolean r101);

    String getActive();

    LiveData<Content> getContent();

    void scrollTo(String r100);

    void setActive(String r100);
}
