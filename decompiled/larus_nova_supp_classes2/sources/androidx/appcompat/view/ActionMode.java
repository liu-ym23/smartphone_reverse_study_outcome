package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class ActionMode {
    private Object mTag;
    private boolean mTitleOptionalHint;

    public interface Callback {
        boolean onActionItemClicked(ActionMode r1, MenuItem r2);

        boolean onCreateActionMode(ActionMode r1, Menu r2);

        void onDestroyActionMode(ActionMode r1);

        boolean onPrepareActionMode(ActionMode r1, Menu r2);
    }

    public ActionMode() {
    }

    public abstract void finish();

    public abstract View getCustomView();

    public abstract Menu getMenu();

    public abstract MenuInflater getMenuInflater();

    public abstract CharSequence getSubtitle();

    public abstract CharSequence getTitle();

    public abstract void invalidate();

    public boolean isTitleOptional() {
        return false;
    }

    public boolean isUiFocusable() {
        return true;
    }

    public abstract void setCustomView(View r1);

    public abstract void setSubtitle(int r1);

    public abstract void setSubtitle(CharSequence r1);

    public abstract void setTitle(int r1);

    public abstract void setTitle(CharSequence r1);

    public Object getTag() {
        return this.mTag;
    }

    public boolean getTitleOptionalHint() {
        return this.mTitleOptionalHint;
    }

    public void setTag(Object r1) {
        this.mTag = r1;
    }

    public void setTitleOptionalHint(boolean r1) {
        this.mTitleOptionalHint = r1;
    }
}
