package da5;

import androidx.lifecycle.LiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface d<Content> {
    void changeCollapseStatus(String r1, boolean r2);

    String getActive();

    LiveData<Content> getContent();

    void scrollTo(String r1);

    void setActive(String r1);
}
