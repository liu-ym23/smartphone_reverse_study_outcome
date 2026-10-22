package com.larus.office.plugins.input;

/* JADX INFO: loaded from: classes30.dex */
public interface m1 extends k1 {

    public static final class a {
        public static /* synthetic */ void a(m1 r100, String r101, boolean r102, boolean r103, int r104) {
            if ((r104 & 4) == 0) goto L5;
            r103 = false;
        L5:
            r100.setChatInputVisible(r101, r102, r103, false);
        }
    }

    int getAIEditState();

    String getLatestDocMessageId();

    void markAiEditTriggeredForCurrentAnswer(String r100, boolean r101);

    void notifyInterruptConversation();

    void notifyPanelHeightChanged();

    void onAIEditStateIdle();

    void onDocStateChanged(boolean r100);

    void onReferenceCacheCleared(String r100);

    void onSelectionChanged(String r100, String r101);

    void setChatInputVisible(String r100, boolean r101, boolean r102, boolean r103);

    void setToAiEdit();

    void updateLoadingDocState(int r100);
}
