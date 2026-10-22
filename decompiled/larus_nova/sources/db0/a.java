package db0;

import cb0.c;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public interface a {
    Observable<c> findMidiSegment(long r100);

    c findMidiSegmentOpt(long r100);

    Single<List<c>> findMidiSegments(long r100, long r101);

    List<c> findMidiSegmentsOpt(long r100, long r101);
}
