package androidx.appcompat.app;

import androidx.appcompat.view.ActionMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface AppCompatCallback {
    void onSupportActionModeFinished(ActionMode r1);

    void onSupportActionModeStarted(ActionMode r1);

    ActionMode onWindowStartingSupportActionMode(ActionMode.Callback r1);
}
