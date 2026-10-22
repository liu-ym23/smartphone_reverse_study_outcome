package uob;

import android.text.Editable;
import android.text.TextWatcher;
import com.ss.android.lark.keyboard.plugin.tool.voice.vote.DownVoteInputAdapter;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownVoteInputAdapter f550977a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public a(DownVoteInputAdapter r100) {
        this.f550977a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        this.f550977a.getClass();
    }
}
