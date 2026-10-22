package com.larus.bmhome.double_post.fragment;

import com.larus.bmhome.video.RecommendVideoData;
import com.larus.bmhome.video.SortRequestType;
import com.larus.bmhome.video.SortScene;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes26.dex */
public interface w {
    void a();

    Object b(SortScene r100, SortRequestType r101, int r102, List<String> r103, List<String> r104, String r105, String r106, Continuation<? super RecommendVideoData> r107);

    Object c(SortScene r100, SortRequestType r101, int r102, List<String> r103, List<String> r104, String r105, String r106, Continuation<? super RecommendVideoData> r107);
}
