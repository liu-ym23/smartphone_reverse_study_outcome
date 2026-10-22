package dagger.hilt.android;

/* JADX INFO: loaded from: classes41.dex */
public interface ActivityRetainedLifecycle {

    public interface OnClearedListener {
        void onCleared();
    }

    void addOnClearedListener(OnClearedListener r100);

    void removeOnClearedListener(OnClearedListener r100);
}
