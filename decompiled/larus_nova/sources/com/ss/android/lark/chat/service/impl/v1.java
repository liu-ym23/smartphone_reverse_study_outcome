package com.ss.android.lark.chat.service.impl;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.todo.impl.features.detail.comment.CommentKeyboardSection$handleActivityResult$1;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import com.ss.android.lark.videosend.tools.VideoCoverManager;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class v1 implements m6b.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m6b.l f416584a;

    public class a implements ObservableOnSubscribe<Map<String, FrameInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f416585a;

        public a(List r100) {
            this.f416585a = r100;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Map<String, FrameInfo>> r100) throws Exception {
            HashMap r101 = new HashMap();
            Iterator r102 = this.f416585a.iterator();
        L4:
            if (r102.hasNext() == false) goto L9;
            String r103 = ((VideoInfo) r102.next()).getPath();
            if (r101.containsKey(r103) == true) goto L4;
            VideoCoverManager.a r104 = VideoCoverManager.getVideoCover(ChatCoreModule.a().getContext(), r103);
            r101.put(r103, new FrameInfo(r104.f444975a, r104.f444976b, r104.f444977c));
            goto L4
        L9:
            r100.onNext(r101);
            r100.onComplete();
        }
    }

    @Inject
    public v1(m6b.l r100) {
        this.f416584a = r100;
    }

    @Override // m6b.m
    public final Observable<Map<String, FrameInfo>> Db(List<VideoInfo> r100) {
        return Observable.create(new a(r100));
    }

    @Override // m6b.m
    public final void d2(final String r100, final boolean r101, final IGetDataCallback<List<MessageInfo>> r102) {
        Observable r103 = Observable.create(new o1(this, r100, r101)).map(new p1(r100)).subscribeOn(LarkRxSchedulers.io());
        Objects.requireNonNull(r102);
        r103.subscribe(new q1(r102), com.ss.android.lark.utils.rxjava.a.C5377a.f444759a);
    }

    @Override // m6b.m
    public final Observable M4(List r100, final boolean r101, final CommentKeyboardSection$handleActivityResult$1 r102, final Biz r103, final Scene r104) {
        return Observable.fromIterable(r100).concatMap(new r1(r101, r102, r103, r104)).concatMap(new s1()).subscribeOn(LarkRxSchedulers.io());
    }
}
